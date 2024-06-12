package bg.graduationApp.Graduation.App.web.controller;

import bg.graduationApp.Graduation.App.data.entity.GraduationThesis;
import bg.graduationApp.Graduation.App.exceptions.GraduationThesisExistsException;
import bg.graduationApp.Graduation.App.services.GraduationThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student/graduationThesis")
@CrossOrigin(origins = "http://localhost:3000")
public class GraduationThesisController {

    private final GraduationThesisService graduationThesisService;

    @Autowired
    public GraduationThesisController(GraduationThesisService graduationThesisService) {
        this.graduationThesisService = graduationThesisService;
    }

    @GetMapping("/allGraduationTheses")
    @PreAuthorize("hasRole('client_student')")
    public List<GraduationThesis> getAllGraduationTheses() {
        return graduationThesisService.getAllGraduationTheses();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('client_student')")
    public void createNewApplication(@RequestBody GraduationThesis graduationThesis) {
        Long studentId = graduationThesis.getStudentId();

        if (graduationThesisService.findGraduationByStudent_Id(studentId).isPresent()) {
            throw new GraduationThesisExistsException(studentId);
        }
        graduationThesisService.addNewGraduationThesis(graduationThesis, studentId);
    }
}
