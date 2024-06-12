package bg.graduationApp.Graduation.App.services.implementations;

import bg.graduationApp.Graduation.App.data.entity.Student;
import bg.graduationApp.Graduation.App.data.repository.StudentRepository;
import bg.graduationApp.Graduation.App.exceptions.EmailTakenException;
import bg.graduationApp.Graduation.App.exceptions.FacultyNumberTakenException;
import bg.graduationApp.Graduation.App.exceptions.StudentNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

//
//    @BeforeEach
//    void setUp() {
//        studentService = new StudentServiceImpl(studentRepository);
//    }

    @Test
    void getAllStudents() {
        //when
        studentService.getAllStudents();

        //then
        verify(studentRepository).findAll();
    }

    @Test
    void addNewStudent() {
        //given
        String email = "marina@abv.bg";
        Student student = new Student();
        student.setEmail(email);
        student.setFirstName("Marina");

        //when
        studentService.addNewStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        // assertThat(capturedStudent).isEqualTo(student);
        assertEquals(capturedStudent, student);
    }

    @Test
    void addNewStudent_ThrowExceptionWhenEmailIsTaken() {
        //given
        String email = "marina@abv.bg";
        Student student = new Student();
        student.setEmail(email);
        student.setFirstName("Marina");

        given(studentRepository.findStudentByEmail(anyString()))
                .willReturn(Optional.of(student));
        //when
        //that
        assertThatThrownBy(() -> studentService.addNewStudent(student))
                .isInstanceOf(EmailTakenException.class)
                .hasMessageContaining(student.getEmail());

        //make sure that the mock never saves any student
        verify(studentRepository, never()).save(any());
    }

    @Test
    void addNewStudent_ThrowExceptionWhenFacultyNumberIsTaken() {
        //given
        String email = "marina@abv.bg";
        String fn = "F456";
        Student student = new Student();
        student.setEmail(email);
        student.setFacultyNumber(fn);

        given(studentRepository.findStudentByFacultyNumber(anyString()))
                .willReturn(Optional.of(student));
        //when
        //that
        assertThatThrownBy(() -> studentService.addNewStudent(student))
                .isInstanceOf(FacultyNumberTakenException.class)
                .hasMessageContaining(student.getFacultyNumber());

        //make sure that the mock never saves any student
        verify(studentRepository, never()).save(any());
    }

    @Test
    void deleteStudent() {
        Long id = 1L;

        given(studentRepository.existsById(id)).willReturn(true);

        studentService.deleteStudent(id);

        then(studentRepository).should(times(1)).deleteById(id);
    }

    @Test
    void deleteStudent_ThrowExceptionWhenStudentDoesNotExist() {
        Long id = -2L;

        given(studentRepository.existsById(id)).willReturn(false);

        assertThatThrownBy(() -> studentService.deleteStudent(id))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining(String.valueOf(id));

    }
    @Test
    void updateStudent() {
    }

    @Test
    void findStudentByEmail() {
    }

    @Test
    void findStudentById() {
    }
}