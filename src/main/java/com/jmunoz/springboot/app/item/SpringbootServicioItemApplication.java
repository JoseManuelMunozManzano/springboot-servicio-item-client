package com.jmunoz.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Con solo informar la dependencia en el pom (eureka-client) de forma automática se configura como cliente.
// Pero igualmente es buena práctica (no obligatorio) indicarlo con una anotación en la clase principal.
// Se indica de forma explícita con la anotación @EnableEurekaClient
@EnableEurekaClient
@RibbonClient(name="servicio-productos")
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
