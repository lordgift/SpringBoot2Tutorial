package th.in.lordgift.SpringBoot2Tutorial.repository;

import org.springframework.stereotype.Repository;
import th.in.lordgift.SpringBoot2Tutorial.model.entity.MyUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class QueryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<MyUser> queryNativeMyUser() {
        Query query = entityManager.createNativeQuery("SELECT NAME, LAST_UPDATED FROM MY_USER", MyUser.class);
        List<MyUser> list = (List<MyUser>) query.getResultList();
        //return object[]
        return list;
    }

    public List<MyUser> queryMyUser() {
        Query query = entityManager.createQuery("FROM MyUser o ");
        List<MyUser> list = (List<MyUser>) query.getResultList();
        return list;
    }

}
