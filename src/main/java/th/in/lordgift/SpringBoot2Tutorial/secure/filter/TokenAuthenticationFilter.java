package th.in.lordgift.SpringBoot2Tutorial.secure.filter;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader("Authorization");
        if(authorization == null || authorization.isEmpty()) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "คนไม่มีสิทธิ์");
            return;
        }

        //TODO check token is valid

        doFilter(httpServletRequest,httpServletResponse, filterChain);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        Collection<String> excludeUrlPatterns = new ArrayList<>();
        excludeUrlPatterns.add("/auth/*");

        AntPathMatcher pathMatcher = new AntPathMatcher();
        return excludeUrlPatterns.stream()
                .anyMatch(p -> pathMatcher.match(p, request.getServletPath()));
    }
}
