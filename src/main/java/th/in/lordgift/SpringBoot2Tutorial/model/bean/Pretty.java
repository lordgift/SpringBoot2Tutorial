package th.in.lordgift.SpringBoot2Tutorial.model.bean;

import java.time.LocalDate;

public class Pretty {

    private String codename;
    private String star;
    private Long price;
    private LocalDate birthdate;

    public Pretty() {

    }

    public Pretty(String codename, String star, Long price) {
        this.codename = codename;
        this.star = star;
        this.price = price;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
