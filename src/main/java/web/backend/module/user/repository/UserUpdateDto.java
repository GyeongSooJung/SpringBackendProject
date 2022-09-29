package web.backend.module.user.repository;

import lombok.Data;
import web.backend.module.user.User;

@Data
public class UserUpdateDto {
    private Long id;
    private User user;
}
