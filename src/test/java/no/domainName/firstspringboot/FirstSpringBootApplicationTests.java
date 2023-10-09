package no.domainName.firstspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest //--> This is saying ""I want you to load my entire spring boot application and then run these test""
class FirstSpringBootApplicationTests {

	@Autowired //looks for all partController components
	private PartController partController;

	@Test
	void contextLoads() { //if we want to check if partController gets initiated
		assertThat(partController).isNotNull();
	}



}
