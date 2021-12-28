package io.robb.jpastuff.jpaonetoone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaOneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneApplication.class, args);
    }

    @Bean
    CommandLineRunner run(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("That was interesting");
            }
        };
    }
}
