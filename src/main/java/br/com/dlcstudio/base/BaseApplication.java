package br.com.dlcstudio.base;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {	
	}
}
