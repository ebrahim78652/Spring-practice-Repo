package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"tacos.data"})
public class TacoApplication {

    public static void main(String[] args) {

        SpringApplication.run(TacoApplication.class, args);
    }

}
