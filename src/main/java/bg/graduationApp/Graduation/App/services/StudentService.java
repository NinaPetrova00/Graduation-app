package bg.graduationApp.Graduation.App.services;

import bg.graduationApp.Graduation.App.data.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    void addNewStudent(Student student);

    void deleteStudent(Long studentId);

    //todo: change the update from name to firstName, etc...
    void updateStudent(Long studentId, String name, String email);

    void findStudentByEmail(String email);

    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByFacultyNumber(String facultyNumber);
}
