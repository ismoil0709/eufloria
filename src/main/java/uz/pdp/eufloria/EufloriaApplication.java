package uz.pdp.eufloria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EufloriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EufloriaApplication.class, args);
    }
}
