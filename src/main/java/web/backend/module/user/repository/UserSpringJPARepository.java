package web.backend.module.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.backend.module.user.User;

public interface UserSpringJPARepository extends JpaRepository<User, Long> {
}
