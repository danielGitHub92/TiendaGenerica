package com.example.TiendaGenerica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.TiendaGenerica"})
public class TiendaGenericaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaGenericaApplication.class, args);
	}

}
