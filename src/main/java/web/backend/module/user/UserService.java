package web.backend.module.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.backend.module.user.repository.UserQueryRepository;
import web.backend.module.user.repository.UserSpringJPARepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserQueryRepository userQueryRepository;
    private final UserSpringJPARepository userSpringJPARepository;

}
