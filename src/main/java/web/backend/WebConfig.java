package web.backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import web.backend.aop.AopConfig;
import web.backend.interceptor.LogInterceptor;
import web.backend.module.user.User;
import web.backend.module.user.repository.UserSpringJpaRepository;
import web.backend.redis.RedisConfig;

@Configuration
@Import({AopConfig.class, RedisConfig.class})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/css/**", "/*.ico"
                        , "/error", "/error-page/**" //오류 페이지 경로
                );
    }

    @Autowired
    UserSpringJpaRepository userSpringJpaRepository;

    @Bean
    public void addUsers() {
        for(int i = 0; i < 10; i++) {
            User user = new User();
            user.changeUser("member" + i);
            userSpringJpaRepository.save(user);
        }
    }

}
