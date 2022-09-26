package web.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BackendApplication {

	public static void main(String[] args) {
		log.info("test={}","test");
		log.error("error={}","error");
		SpringApplication.run(BackendApplication.class, args);
	}

}
