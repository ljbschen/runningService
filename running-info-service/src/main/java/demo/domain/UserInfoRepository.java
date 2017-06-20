package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String userName);
}
