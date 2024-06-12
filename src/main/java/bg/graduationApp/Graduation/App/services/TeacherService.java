package bg.graduationApp.Graduation.App.services;


import bg.graduationApp.Graduation.App.data.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    void addNewTeacher(Teacher teacher);

    void deleteTeacher(Long teacherId);

    void updateTeacher(Long teacherId, String firstName, String lastName, String email);
}
