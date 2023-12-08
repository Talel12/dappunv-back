package tn.enig.DappUnv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @EntityScan(basePackages = "tn.enig.DappUnv.model")
// @ComponentScan(basePackages = {"tn.enig.DappUnv.repository", "tn.enig.DappUnv.service"})
@ComponentScan(basePackages = "tn.enig.DappUnv")

public class DappUnvApplication {

	public static void main(String[] args) {
		SpringApplication.run(DappUnvApplication.class, args);
	}

}
