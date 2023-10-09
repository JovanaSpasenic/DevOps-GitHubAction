package no.domainName.firstspringboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//annutation: java reflection. Reflection is java has ability to look at the code while it is running
@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

}
