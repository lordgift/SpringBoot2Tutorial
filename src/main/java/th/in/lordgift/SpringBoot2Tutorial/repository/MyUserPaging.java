package th.in.lordgift.SpringBoot2Tutorial.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import th.in.lordgift.SpringBoot2Tutorial.model.entity.MyUser;

@Repository
public interface MyUserPaging extends PagingAndSortingRepository<MyUser, Long> {

}
