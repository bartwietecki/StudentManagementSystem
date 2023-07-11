package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    private StudentController studentController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        studentController = new StudentController(studentService);
    }

    @Test
    void testListStudents() {
        // given
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());

        when(studentService.getAllStudents()).thenReturn(students);

        // when
        String viewName = studentController.listStudent(model);

        // then
        assertEquals("students", viewName);
        verify(model, times(1)).addAttribute("students", students);
    }

    @Test
    void testCreateStudentForm() {
        // when
        String viewName = studentController.createStudentForm(model);

        // then
        assertEquals("create_student", viewName);
        verify(model, times(1)).addAttribute("student", new Student());
    }

    @Test
    void testSaveStudent() {
        // given
        Student student = new Student();
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setEmail("jankowalski@gmail.com");

        // when
        String viewName = studentController.saveStudent(student);

        // then
        assertEquals("redirect:/students", viewName);
        verify(studentService, times(1)).saveStudent(student);
    }

    @Test
    void editStudentForm() {
        // given
        Long studentId= 1L;
        Student student = new Student();
        student.setId(studentId);
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setEmail("jankowalski@gmail.com");

        when(studentService.getStudentById(studentId)).thenReturn(student);

        // when
        String viewName = studentController.editStudentForm(studentId, model);

        // then
        assertEquals("edit_student", viewName);
        verify(model, times(1)).addAttribute("student", student);
    }

    @Test
    void updateStudent() {
        // given
        Long studentId= 1L;
        Student existingStudent = new Student();
        existingStudent.setId(studentId);
        existingStudent.setFirstName("Jan");
        existingStudent.setLastName("Kowalski");
        existingStudent.setEmail("jankowalski@gmail.com");

        Student updatedStudent = new Student();
        updatedStudent.setId(studentId);
        updatedStudent.setFirstName("Adam");
        updatedStudent.setLastName("Nowak");
        updatedStudent.setEmail("adamnowak@gmail.com");

        when(studentService.getStudentById(studentId)).thenReturn(existingStudent);

        // when
        String viewName = studentController.updateStudent(studentId, updatedStudent, model);

        // then
        assertEquals("redirect:/students", viewName);
        verify(studentService, times(1)).updateStudent(existingStudent);
    }

    @Test
    void deleteStudent() {
        // given
        Long studentId= 1L;

        // when
        String viewName = studentController.deleteStudent(studentId);

        // then
        assertEquals("redirect:/students", viewName);
        verify(studentService, times(1)).deleteStudentById(studentId);
    }

}