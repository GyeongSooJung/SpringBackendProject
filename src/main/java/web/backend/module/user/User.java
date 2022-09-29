package web.backend.module.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="user_info")
public class User {

    @Id @GeneratedValue
    @Column(name="user_index")
    private Long id;

    @Column(name="user_id")
    private String userId;

    @CreatedDate
    @Column(name="user_createdAt", updatable = false)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime user_creadtedAt;

    @LastModifiedDate
    @Column(name="user_updatedAt")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime user_updatedAt;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        user_creadtedAt = now;
        user_updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        user_updatedAt = LocalDateTime.now();
    }

    public User(String userId) {
        this.userId = userId;
    }

    /**
     * user 수정
     */
    public void changeUser(String userId) {
        this.userId = userId;
    }

}
