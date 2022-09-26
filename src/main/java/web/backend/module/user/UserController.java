package web.backend.module.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

}