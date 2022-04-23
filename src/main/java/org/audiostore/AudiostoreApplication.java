package org.audiostore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class AudiostoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudiostoreApplication.class, args);
	}

}
