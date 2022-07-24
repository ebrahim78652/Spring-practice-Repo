package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//this tells spring to look into this class for bean declarations
@Configuration
public class MyConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:h2:mem:tacocloud");
        return dataSource;
    }

    //this bean will be stored into the application context
    @Bean
    JdbcTemplate jdbcTemplate() {
//your code to configure the data source goes here
        return new JdbcTemplate(dataSource());
    }

}