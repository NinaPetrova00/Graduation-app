package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.GraduationThesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GraduationThesisRepository extends JpaRepository<GraduationThesis, Long> {

    Optional<GraduationThesis> findGraduationByStudent_Id(Long studentId);
}
