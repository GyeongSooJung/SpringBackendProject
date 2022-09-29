package web.backend.module.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import web.backend.annotation.LogTrace;
import web.backend.module.user.User;

import java.util.Optional;

public interface UserSpringJpaRepository extends JpaRepository<User, Long> {

    @LogTrace
    Optional<User> findByUserId(String userId);
}
