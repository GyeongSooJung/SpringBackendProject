package web.backend.module.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserQueryRepository {

    private final JPAQueryFactory query;

    public UserQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }
}
