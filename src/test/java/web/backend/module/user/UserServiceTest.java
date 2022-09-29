package web.backend.module.user;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import web.backend.module.user.repository.UserQueryRepository;
import web.backend.module.user.repository.UserSpringJpaRepository;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    UserSpringJpaRepository userSpringJpaRepository;

    @Autowired
    UserQueryRepository userQueryRepository;

    @BeforeEach
    public void before() {
        User user = new User("userId");
        User savedUser = userSpringJpaRepository.save(user);
    }

    @AfterEach
    public void after() {
        em.flush();
        em.clear();
    }


    @Test
    @Transactional
    void save() {
        Optional<User> findUser = userSpringJpaRepository.findByUserId("userId");
        String userId = findUser.get().getUserId();

        assertEquals("userId",userId);
    }

    @Test
    @Transactional
    void find() {

        List<User> findAll = userSpringJpaRepository.findAll();

        for( User userOne : findAll) {
            assertEquals("userId",userOne.getUserId());
        }

        User findOne = userSpringJpaRepository.findByUserId("userId").get();
        assertEquals("userId",findOne.getUserId());
    }

    @Test
    @Transactional
    void update() {
        Optional<User> findUser = userSpringJpaRepository.findByUserId("userId");
        User userOne = findUser.get();
        userOne.changeUser("newUserId");

        Optional<User> findNewUser = userSpringJpaRepository.findByUserId("newUserId");

        assertEquals("newUserId",findNewUser.get().getUserId());
    }

    @Test
    @Transactional
    void delete() {
        userSpringJpaRepository.deleteById(1L);

        assertEquals(0,userSpringJpaRepository.findAll().size());
    }


}