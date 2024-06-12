package bg.graduationApp.Graduation.App.services;

import bg.graduationApp.Graduation.App.data.entity.GraduationThesis;
import bg.graduationApp.Graduation.App.data.entity.Student;

import java.util.List;
import java.util.Optional;

public interface GraduationThesisService {

    void addNewGraduationThesis(GraduationThesis graduationThesis, Long studentId);
    List<GraduationThesis> getAllGraduationTheses();

    Optional<GraduationThesis> findGraduationByStudent_Id(Long studentId);
}
