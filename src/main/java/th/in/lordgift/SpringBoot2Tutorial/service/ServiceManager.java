package th.in.lordgift.SpringBoot2Tutorial.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.in.lordgift.SpringBoot2Tutorial.model.entity.MyUser;
import th.in.lordgift.SpringBoot2Tutorial.repository.MyUserPaging;
import th.in.lordgift.SpringBoot2Tutorial.repository.PersistenceRepository;
import th.in.lordgift.SpringBoot2Tutorial.repository.QueryRepository;

import javax.naming.InitialContext;
import java.util.List;

@Service
public class ServiceManager {

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    PersistenceRepository persistenceRepository;

    @Autowired
    MyUserPaging myUserPaging;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<MyUser> queryNativeMyUser() {
        return queryRepository.queryNativeMyUser();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<MyUser> queryMyUser() {
        return queryRepository.queryMyUser();
    }

    @Transactional(rollbackFor = ConstraintViolationException.class)
    public MyUser addMyUser(MyUser myUser) throws ConstraintViolationException {
        return persistenceRepository.addMyUser(myUser);
    }

    public Page<MyUser> queryMyUser(Pageable pageable) {
        return myUserPaging.findAll(pageable);
    }
}