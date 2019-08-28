package lsis.pal.assign.finalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@SpringBootApplication
@EnableWebSecurity
public class FinalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAppApplication.class, args);
	}

}
