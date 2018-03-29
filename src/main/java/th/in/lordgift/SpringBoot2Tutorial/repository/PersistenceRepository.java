package th.in.lordgift.SpringBoot2Tutorial.repository;

import org.springframework.stereotype.Repository;
import th.in.lordgift.SpringBoot2Tutorial.model.entity.MyUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.FileNotFoundException;

@Repository
public class PersistenceRepository {

    @PersistenceContext
    EntityManager entityManager;

    public MyUser addMyUser(MyUser myUser) {
        entityManager.persist(myUser);
        return myUser;
    }

}
