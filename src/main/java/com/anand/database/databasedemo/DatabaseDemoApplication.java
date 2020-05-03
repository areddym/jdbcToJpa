package com.anand.database.databasedemo;

import com.anand.database.databasedemo.entity.Person;
import com.anand.database.databasedemo.entity.PersonJdbc;
import com.anand.database.databasedemo.jdbc.PersonJdbcDao;
import com.anand.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personJdbcDao;

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {

		//jdbcTemplateFlow();
		jpaEntityManagerFlow();
	}

	public void jdbcTemplateFlow() {

		logger.info("--------------jdbc template flow executing...--------------------");

		logger.info("find all{}"+ personJdbcDao.findAll());


		logger.info("finfByid {}", personJdbcDao.findById(10001));

		logger.info("deleteByid {}", personJdbcDao.deleteById(10001));

		logger.info("Inserting 10004 -> {}",
				personJdbcDao.insert(new PersonJdbc(10004, "Tara", "Berlin", new Date())));

		logger.info("Update 10003 -> {}",
				personJdbcDao.update(new PersonJdbc(10003, "Pieter", "Utrecht", new Date())));


		logger.info("find all custom row mapper{}"+ personJdbcDao.findAllUsingCustomRowmapper());


		logger.info("finfByid custom row mapper{}", personJdbcDao.findByIdUsingCustomRowmapper(10003));

		logger.info("--------------jdbc template flow end...--------------------");
	}

	public void jpaEntityManagerFlow() {

		logger.info("--------------jpaEntityManagerFlow executing...--------------------");

		logger.info("find all{}"+ personJpaRepository.findAll());


		logger.info("finfByid {}", personJpaRepository.findById(10001));

		logger.info("Inserting -> {}",
				personJpaRepository.insert(new Person("Tara", "Berlin", new Date())));

		logger.info("Update 10003 -> {}",
				personJpaRepository.update(new Person(10003, "Pieter", "Utrecht", new Date())));

		personJpaRepository.deleteById(10002);

		logger.info("All users -> {}", personJpaRepository.findAll());

		logger.info("--------------jpaEntityManagerFlow flow end...--------------------");
	}
}
