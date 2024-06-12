package bg.graduationApp.Graduation.App.data.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class ThesisDefense {
    //Дипломна защита

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Grade> gradeList;
}
