package web.backend.module.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import web.backend.annotation.LogTrace;
import web.backend.module.user.repository.UserUpdateDto;
import web.backend.response.CommonResponse;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public CommonResponse<List<User>> findAll() throws Exception {
        return new CommonResponse<List<User>>(true, userService.findAll());
    }

    @GetMapping("/{userId}")
    public CommonResponse<User> findByIndexId(@PathVariable(value = "userId") Long userId ) {
        return new CommonResponse<User>(true, userService.findByIndexId(userId));
    }

    @PostMapping
    public CommonResponse<String> save(@RequestBody User user) {
        return new CommonResponse<String>(true, userService.save(user));
    }

    @PatchMapping
    public CommonResponse<String> update(@RequestBody UserUpdateDto user) {
        return new CommonResponse<String>(true, userService.update(user.getId(), user.getUser()));
    }

    @DeleteMapping
    public CommonResponse<String> delete(@RequestParam Long id) {
        return new CommonResponse<String>(true, userService.delete(id));
    }

}
