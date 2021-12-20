package com.somegroup.marketplace;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableR2dbcRepositories
public class MarketplaceApplication {


	public static void main(String[] args) throws IOException {
		System.out.println(Files.list(Path.of("/usr/local/app/db/migration/")).collect(Collectors.toList()));
		SpringApplication.run(MarketplaceApplication.class, args);
	}

}
