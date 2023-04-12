package com.granjacontrol.granjacontrol;

import com.granjacontrol.granjacontrol.model.entity.Ciclo;
import com.granjacontrol.granjacontrol.model.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GranjaControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GranjaControlApplication.class, args);
	}

}
