package bg.graduationApp.Graduation.App.web.controller;

import bg.graduationApp.Graduation.App.data.entity.Teacher;
import bg.graduationApp.Graduation.App.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/allTeachers")
    public List<Teacher> getTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping("/create")
    public void addNewTeacher(@RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId")Long teacherId){
        teacherService.deleteTeacher(teacherId);
    }
}
