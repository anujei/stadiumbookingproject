package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
	
	public WebMvcConfigurer corsconfConfigurer()
	{
		return new WebMvcConfigurer() {

			private static final String GET = "GET";
			private static final String POST =  "POST";
			private static final String DELETE = "DELETE";
			private static final String PUT = "PUT";
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				registry.addMapping("/**").allowCredentials(false)
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedMethods(GET,POST,DELETE,PUT)
				.allowedOriginPatterns("*");
			}
			
			
		};
		
	}

}
