package no.jlwcrews.jpa_with_sanity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableScheduling
@EnableJpaAuditing
public class JpaWithSanityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaWithSanityApplication.class, args);
    }

}
