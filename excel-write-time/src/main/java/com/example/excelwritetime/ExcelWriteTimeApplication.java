package com.example.excelwritetime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.time.LocalDate;

@SpringBootApplication
public class ExcelWriteTimeApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ExcelWriteTimeApplication.class, args);
		StudentService studentService = context.getBean(StudentService.class);
		try {
			studentService.exportToExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	@Bean
//	CommandLineRunner commandLineRunner(StudentRepo studentRepo) {
//
//		return args -> {
//
//			for (int i = 0; i < 5000; i++) {
//				Student student = Student.builder()
//						.firstName("Ash")
//						.middleName("White")
//						.lastName("Lothbrok")
//						.address("Mexico")
//						.dateOfBirth(LocalDate.of(2000, 10, 10))
//						.phoneNumber("9800000000")
//						.emergencyContactNumber("9811111111")
//						.emergencyContactName("Shyam Prasad")
//						.marriedStatus("Single")
//						.gender("Male")
//						.caste("Scandinavian")
//						.nationality("Nepali")
//						.citizenshipNumber("5-25-23456")
//						.profilePicUrl("ash.pic.com")
//						.activeStatus(true)
//						.personalEmail("ash@gmail.com")
//						.ecRelationShip("Noone")
//						.build();
//
//				studentRepo.save(student);
//			}
//		};
//	}
}
