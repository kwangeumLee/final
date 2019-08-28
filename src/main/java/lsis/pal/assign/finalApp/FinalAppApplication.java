package lsis.pal.assign.finalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class FinalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAppApplication.class, args);
	}

	@Bean
	PalMemberRepository palMemberRepository(DataSource dataSource) {
		return new JdbcPalMemberRepository(dataSource);
	}

}
