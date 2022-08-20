package com.jmunoz.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Con solo informar la dependencia en el pom (eureka-client) de forma automática se configura como cliente.
// Pero igualmente es buena práctica (no obligatorio) indicarlo con una anotación en la clase principal.
// Se indica de forma explícita con la anotación @EnableEurekaClient
//
// Ribbon no es necesario pero Feign si, ya que lo necesitamos para conectarnos a las API REST
//
// Habilitamos Hystrix con la anotación @EnableCircuitBreaker. Se encarga, mediante un hilo separado, de la
// comunicación de los microservicios. Envuelve a Ribbon, que aunque no lo tenemos en el POM viene incluido por
// defecto en el cliente Eureka (hasta la versión de SpringBoot 2.3), para tolerancia a fallos, manejo de latencia
// y time-out.
// Para probar Hystrix, en el proyecto de servicio de productos
// (https://github.com/JoseManuelMunozManzano/springboot-servicio-productos-client) se va a simular un error
//
// A partir de la versión de SpringBoot 2.4 en vez de Ribbon viene Spring Cloud Load Balancer y en vez de Hystrix
// hay que usar Resilience4j.
@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
