package com.mtp.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mtp.app.entities.Person;
import com.mtp.app.service.PeopleMgmtService;

@SpringBootApplication
public class Sb04PeopleMgmtSpringDataApplication implements CommandLineRunner {

	@Autowired
	private PeopleMgmtService peopleMgmtService;
	
	public static void main(String[] args) {
		SpringApplication.run(Sb04PeopleMgmtSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createPerson();
		createPersons();
	}

	private void createPersons() {
		List<Person> personList = Arrays.asList(new Person("Dharmendra", "Kumar", "dh2@gmail.com", new Date()), 
								new Person("Rajendra", "Kumar", "Raj2@gmail.com", new Date()));
		Iterable<Person> createdPerson = peopleMgmtService.createPersons(personList);
		for(Person person: createdPerson) {
			System.out.println(person);
		}
	}

	private void createPerson() {
		Person person = new Person("Jitendra", "Kumar", "jeet1262.jp@gmail.com", new Date());
		Person personDb = peopleMgmtService.createPerson(person);
		System.out.println(personDb);
	}
}
