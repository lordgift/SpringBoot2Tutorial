package th.in.lordgift.SpringBoot2Tutorial.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "MY_USER", schema = "NHADEV", catalog = "")
public class MyUser {
    private Long id;
    private String name;
    private String position;
    private LocalDateTime lastUpdated;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "LAST_UPDATED")
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser myUser = (MyUser) o;
        return Objects.equals(id, myUser.id) &&
                Objects.equals(name, myUser.name) &&
                Objects.equals(position, myUser.position) &&
                Objects.equals(lastUpdated, myUser.lastUpdated);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, position, lastUpdated);
    }
}
