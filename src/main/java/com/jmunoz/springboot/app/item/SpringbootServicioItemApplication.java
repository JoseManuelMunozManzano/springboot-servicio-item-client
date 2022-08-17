package com.jmunoz.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Se va a ver la librería Feign, otra forma de implementar un cliente http para la comunicación entre microservicios.
// Es una alternativa a utilizar RestTemplate. Es más sencilla, usando interfaces y anotaciones de forma declarativa.
//
// Feign es desarrollada por Netflix y forma parte de Spring Cloud.
// Se integra con el balanceo de carga, de Ribbon y también viene configurado en los clientes de Eureka...
// Por ahora lo vamos a hacer sencillo, centrándonos en el uso de Feign como cliente http.
//
// Con la anotación @EnableFeignClients, se habilitan nuestros clientes Feign que tengamos implementado en el
// proyecto, y además nos permite inyectar estos clientes en nuestros controladores u otros componentes de Spring,
// es decir, habilita la inyección de dependencias, el @Autowired
//
// Configuración de Ribbon Client para que funcione la parte del properties
// En la anotación @RibbonClient se indica el mismo nombre que tenemos en ProductoClienteRest
@RibbonClient(name="servicio-productos")
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
