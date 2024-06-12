package bg.graduationApp.Graduation.App.services;

import bg.graduationApp.Graduation.App.data.entity.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGrades();

    void addNewGrade(Grade grade, Long studentId);
}
