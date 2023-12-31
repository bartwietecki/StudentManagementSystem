package net.javaguides.sms;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student(1L, "Bart", "Wietecki", "bartwietecki@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student(2L, "John", "Deere", "johndeere@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student(3L, "Tom", "Cruise", "tomcruise@gmail.com");
//		studentRepository.save(student3);

	}
}
