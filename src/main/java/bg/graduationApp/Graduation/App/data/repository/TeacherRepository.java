package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findTeacherByEmail(String email);
}
