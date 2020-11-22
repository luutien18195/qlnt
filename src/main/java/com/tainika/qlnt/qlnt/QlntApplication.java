package com.tainika.qlnt.qlnt;

import com.tainika.qlnt.qlnt.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class QlntApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlntApplication.class, args);
	}

}
