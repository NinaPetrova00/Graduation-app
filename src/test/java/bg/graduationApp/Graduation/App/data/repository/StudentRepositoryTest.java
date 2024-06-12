package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        // delete the test data after the test
        studentRepository.deleteAll();
    }

    @Test
    void findStudentByEmail_Exists() {
        //given
        String email = "marina@abv.bg";
        Student student = new Student();
        student.setEmail(email);
        student.setFirstName("Marina");
        studentRepository.save(student);

        //when
        Optional<Student> studentExists = studentRepository.findStudentByEmail(email);

        //then
        assertTrue(studentExists.isPresent());
    }

    @Test
    void findStudentByEmail_NotExists() {
        //given
        String email = "1@abv.bg";
        //when
        Optional<Student> studentExists = studentRepository.findStudentByEmail(email);

        //then
        assertFalse(studentExists.isPresent());
    }

}