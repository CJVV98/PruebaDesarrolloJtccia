package net.jaimetorres.pruebades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(SwaggerConfig.class)
@SpringBootApplication
@ComponentScan(basePackages = "net.jaimetorres.pruebades")
public class PruebaDesarrolloApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaDesarrolloApplication.class, args);
	}

}
