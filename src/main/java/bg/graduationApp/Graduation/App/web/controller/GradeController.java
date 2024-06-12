package bg.graduationApp.Graduation.App.web.controller;

import bg.graduationApp.Graduation.App.data.entity.Grade;
import bg.graduationApp.Graduation.App.services.GradeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher/grade")
@CrossOrigin(origins = "http://localhost:3000")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/allGrades")
    @PreAuthorize("hasRole('client_teacher')")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('client_teacher')")
    public void createNewGrade(@RequestBody Grade grade) {
        Long studentId = grade.getStudentId();
        System.out.println("test-"+studentId);
        gradeService.addNewGrade(grade,studentId);
    }
}
