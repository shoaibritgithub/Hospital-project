package com.ty.hospital.hospitalappboot;

import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HospitalAppBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppBootApplication.class, args);
	}
	@Bean
	public Docket getDocket()
	{
		springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("Pooja", "www.testyantra.com", "pujapoo984@gmail.com");
		List<VendorExtension> extension = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("HOSPITAL API SERVICE", "HOSPITAL mANAGEMENT SERVICE", "SNAPSHOT 12.2022", "www.testyantra.com", contact, "Licence 12345", "www.testyAntra.com",extension);
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.hospital"))
				.build()
				.apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
	

}
