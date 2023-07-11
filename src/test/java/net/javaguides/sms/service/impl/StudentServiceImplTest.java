package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentServiceImpl studentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void testGetAllStudents() {
        // given
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student());
        studentList.add(new Student());

        when(studentRepository.findAll()).thenReturn(studentList);

        // when
        List<Student> result = studentService.getAllStudents();

        // then
        assertEquals(studentList, result);
    }

    @Test
    void testSaveStudent() {
        // given
        Student student = new Student();
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setEmail("jankowalski@gmail.com");

        when(studentRepository.save(student)).thenReturn(student);

        // when
        Student result = studentService.saveStudent(student);

        // then
        assertEquals(student, result);
    }

    @Test
    void testGetStudentById() {
        // given
        Long studentId = 1L;
        Student student = new Student();
        student.setId(studentId);
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setEmail("jankowalski@gmail.com");

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        // when
        Student result = studentService.getStudentById(studentId);

        // then
        assertEquals(student, result);
    }

    @Test
    void testUpdateStudent() {
        // given
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setEmail("jankowalski@gmail.com");

        when(studentRepository.save(student)).thenReturn(student);

        // when
        Student result = studentService.updateStudent(student);

        // then
        assertEquals(student, result);
    }

    @Test
    void testDeleteStudentById() {
        // given
        Long studentId = 1L;

        // when
        studentService.deleteStudentById(studentId);

        // then
        verify(studentRepository, times(1)).deleteById(studentId);
    }
}