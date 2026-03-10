package com.example.Tablete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Clasa principala de configurare si lansare a aplicatiei Spring Boot.
 * Contine metoda main care initializeaza contextul aplicatiei.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@SpringBootApplication
public class TableteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TableteApplication.class, args);
	}

}
