package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
