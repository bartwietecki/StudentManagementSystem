package net.javaguides.sms.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentTest {

    @Test
    void testConstructorAndGetters() {
        // given
        Long id = 1L;
        String firstName = "Jan";
        String lastName = "Kowalski";
        String email = "jankowalski@gmail.com";

        // when
        Student student = new Student(id, firstName, lastName, email);

        //then
        assertEquals(id, student.getId());
        assertEquals(firstName, student.getFirstName());
        assertEquals(lastName, student.getLastName());
        assertEquals(email, student.getEmail());
    }

    @Test
    void testSetters() {
        // given
        Student student = new Student();

        // when
        student.setId(1L);
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setEmail("jankowalski@gmail.com");

        // then
        assertEquals(1L, student.getId());
        assertEquals("Jan", student.getFirstName());
        assertEquals("Kowalski", student.getLastName());
        assertEquals("jankowalski@gmail.com", student.getEmail());
    }

}