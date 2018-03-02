package com.quantlance;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Country usa = new Country("US", "United States");
		Country canada = new Country("CN", "Canada");
		Country uk = new Country("UK", "United Kingdom");
		Country ukraine = new Country("UA", "Ukraine");
		Country germany = new Country("GM", "Germany");

		countryRepository.save(usa);
		countryRepository.save(canada);
		countryRepository.save(uk);
		countryRepository.save(ukraine);
		countryRepository.save(germany);
	}
}
