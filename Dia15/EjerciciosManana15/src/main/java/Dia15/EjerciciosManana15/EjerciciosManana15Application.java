package Dia15.EjerciciosManana15;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@SpringBootApplication
@OpenAPIDefinition
@EnableWebMvc

public class EjerciciosManana15Application {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosManana15Application.class, args);
	}

}
