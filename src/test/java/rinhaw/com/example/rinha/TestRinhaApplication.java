package rinhaw.com.example.rinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestRinhaApplication {

	public static void main(String[] args) {
		SpringApplication.from(RinhaApplication::main).with(TestRinhaApplication.class).run(args);
	}

}
