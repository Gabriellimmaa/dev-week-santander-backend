package com.project.bootcamp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

	@Value("${application.title}")
	private String _title;

	@Value("${application.description}")
	private String _description;

	@Value("${application.version}")
	private String _version;

	//Cria um document para trabalhar na back-end
	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI().info(new Info()
				.title(_title)
				.description(_description)
				.version(_version)
				.termsOfService("https://swagger.io/terms")
				.license(new License().name("Apache 2.0").url("https://springdoc.org")));
	}

}
