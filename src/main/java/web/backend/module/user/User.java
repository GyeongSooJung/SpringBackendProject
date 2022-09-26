package web.backend.module.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name="user_index")
    private Long id;

    private String userId;

}
