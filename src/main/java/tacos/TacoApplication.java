package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TacoApplication {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate();
    }
    public static void main(String[] args) {

        SpringApplication.run(TacoApplication.class, args);
    }

}
