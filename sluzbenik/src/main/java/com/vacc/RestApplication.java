package com.vacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


/*
 * Glavna klasa Spring Boot aplikacije
 * Da pokrenete primer desni klik i run as java application 
 * Obavezno uraditi Maven Update (desni klik na projekat i maven update)
 * Podesavanja spring aplikacije se vrse u application.properties fajlu u src/main/resources
 * */

@SpringBootApplication
public class RestApplication {

//	@Autowired
//	private Bus bus;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin", "Content-Type",
				"Accept","Authorization","Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method","Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	/*Konfiguracija apache CXF JAX-RS servleta
	 *Moguce je konfigurasati endpoints dynamicki vezano za same klase
	 * */
	
//	@Bean
//	public ServletRegistrationBean<CXFServlet> cxfServlet() {
//		CXFServlet cxfServlet = new CXFServlet();
//		ServletRegistrationBean<CXFServlet> servletReg = new ServletRegistrationBean<CXFServlet>(cxfServlet, "/*");
//		servletReg.setLoadOnStartup(1);
//		return servletReg;
//	}

}
