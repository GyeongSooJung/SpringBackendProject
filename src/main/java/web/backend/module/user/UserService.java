package web.backend.module.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.backend.module.user.repository.UserQueryRepository;
import web.backend.module.user.repository.UserSpringJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    private final UserQueryRepository userQueryRepository;
    private final UserSpringJpaRepository userSpringJPARepository;

    public List<User> findAll() {
        return userSpringJPARepository.findAll();
    }

    @Cacheable(value = "User", key = "#id", cacheManager = "testCacheManager")
    public User findByIndexId(Long id) {
        return userSpringJPARepository.findById(id).get();
    }

    public String save(User user) {
        userSpringJPARepository.save(user);
        return "ok";
    }

    @CachePut(value = "User", key = "#id", cacheManager = "testCacheManager")
    public String update(Long id, User user) {
        User userOne = userSpringJPARepository.findById(id).get();
        userOne.changeUser(user.getUserId());
        return "ok";
    }

    @CacheEvict(value = "User", key = "#id", cacheManager = "testCacheManager")
    public String delete(Long id) {
        userSpringJPARepository.deleteById(id);
        return "ok";
    }


}
