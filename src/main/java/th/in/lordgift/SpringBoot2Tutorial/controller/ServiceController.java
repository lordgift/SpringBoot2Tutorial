package th.in.lordgift.SpringBoot2Tutorial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import th.in.lordgift.SpringBoot2Tutorial.model.bean.Pretty;
import th.in.lordgift.SpringBoot2Tutorial.model.entity.MyUser;
import th.in.lordgift.SpringBoot2Tutorial.secure.MyAuthentication;
import th.in.lordgift.SpringBoot2Tutorial.service.ServiceManager;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    ServiceManager serviceManager;

    @GetMapping(path = "/test", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity test(@AuthenticationPrincipal MyAuthentication authen) {
        return ResponseEntity.ok(authen.getPrincipal());
    }

    /**
     * Sample call service : <BR />
     * GET localhost:8080/spring/api/testQueryParam?singleParam=zzzzzzz
     */
    @GetMapping(path = "/testQueryParam", produces = TEXT_PLAIN_VALUE)
    public ResponseEntity testQueryParam(@RequestParam(value = "singleParam") String singleParam) {
        return ResponseEntity.ok(singleParam);
    }

    /**
     * Sample call service : <BR />
     * GET localhost:8080/spring/api/testQueryParams?param1=abc&param2=def
     */
    @GetMapping(path = "/testQueryParams", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity testQueryParams(@RequestParam Map<String, String> requestParams) {
        String param1 = requestParams.get("param1");
        String param2 = requestParams.get("param2");

        return ResponseEntity.ok(requestParams);
    }


    /**
     * Sample call service : <BR />
     * POST localhost:8080/spring/api/testRequestBody
     */
    @PostMapping(path = "/testRequestBody",
            produces = APPLICATION_JSON_UTF8_VALUE,
            consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity testRequestBody(@RequestBody Pretty pretty) {

        pretty.setPrice(0L);

        return ResponseEntity.ok(pretty);
    }


    @GetMapping(path = "/testPathParam/{id}")
    public ResponseEntity testPathParam(@PathVariable("id") String id) {
        Pretty pretty = new Pretty("Aaaa Bbbb", "**", 5L);
        return ResponseEntity.ok(pretty);
    }


    @GetMapping(path = "/users")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(serviceManager.queryMyUser());
    }

    @PostMapping(path = "/user")
    public ResponseEntity addUser(@RequestBody MyUser user) {
        try {
            return ResponseEntity.ok(serviceManager.addMyUser(user));
        } catch (Exception e) {
//            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
