package org.upskill.apiCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal que inicia a aplicação Spring Boot.
 */
@SpringBootApplication
public class ApiCarApplication {

	/**
	 * Método principal que inicia a aplicação Spring Boot.
	 * @param args Argumentos de linha de comando (não utilizado neste caso).
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiCarApplication.class, args);
	}
}
