package ma.jit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProxiBanqueV4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProxiBanqueV4Application.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBP() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

	};
}
