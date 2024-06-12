package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //responsible for data access
    Optional<Student> findStudentByEmail(String email);

    //todo: do i need it?
    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByFacultyNumber(String facultyNumber);
}
