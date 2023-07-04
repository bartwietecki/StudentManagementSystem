package net.javaguides.sms.repository;

import net.javaguides.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// not adding @Repository, because JpaRepository already has this annotation
public interface StudentRepository extends JpaRepository<Student, Long> {

}
