package com.example.ProjetoLeilaoVespertino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ProjetoLeilaoVespertinoApplication {


	public static void main(String[] args) {
		System.out.println("Iniciando Aplicação Leilão Vespertino");

		SpringApplication.run(ProjetoLeilaoVespertinoApplication.class, args);
		System.out.println("Aplicação Leilão Vespertino Iniciada");
	}

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
