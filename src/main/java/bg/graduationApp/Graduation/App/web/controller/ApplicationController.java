package bg.graduationApp.Graduation.App.web.controller;

import bg.graduationApp.Graduation.App.data.entity.Application;
import bg.graduationApp.Graduation.App.data.entity.Teacher;
import bg.graduationApp.Graduation.App.exceptions.ApplicationsByTeacherNotFoundException;
import bg.graduationApp.Graduation.App.exceptions.StudentDoesNotHaveApplicationException;
import bg.graduationApp.Graduation.App.services.ApplicationService;
import bg.graduationApp.Graduation.App.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/teacher/application")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/allApplications")
    @PreAuthorize("hasRole('client_teacher')")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    //подаване на завление от учител
    @PostMapping("/create")
    @PreAuthorize("hasRole('client_teacher')")
    public void createNewApplication(@RequestBody Application application) {
        Long studentId = application.getStudentId();
        Long teacherId = application.getTeacherId();
        applicationService.addNewApplication(application, studentId, teacherId);
    }


//. Заявлението за дипломна работа се подава от преподавател, разглежда се и се
// одобрява или не се одобрява от департамента, в който се осигурява обучението

    //UPDATE
    @PutMapping(path = "{applicationId}")
    @PreAuthorize("hasRole('client_teacher')")
    public void approveApplication(
            @PathVariable("applicationId") Long applicationId,
            @RequestParam boolean isApproved) {
        applicationService.approveApplication(applicationId, isApproved);
    }

    @GetMapping("/findBy/{studentId}")
    public Optional<Application> findByStudentId(@PathVariable("studentId") Long studentId) {
        Optional<Application> application = applicationService.findApplicationByStudentId(studentId);

        if (application.isEmpty()) {
            throw new StudentDoesNotHaveApplicationException(studentId);
        }
        return application;
    }

    @GetMapping("/approved")
    @PreAuthorize("hasRole('client_teacher')")
    public List<Application> getAllApprovedApplications() {
        return applicationService.getAllApprovedApplications();
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('client_teacher')")
    public List<Application> getAllApplicationsByTopicContainingString(@RequestParam String topicContaining) {
        return applicationService.getAllApplicationsByTopicContainingString(topicContaining);
    }

    @GetMapping("/approvedAndTeacher")
    @PreAuthorize("hasRole('client_teacher')")
    public List<Application> getApprovedApplicationsByTeacher(@RequestParam Long teacherId) {
        if (applicationService.getAllApprovedApplicationsByTeacher(teacherId).isEmpty()) {
            throw new ApplicationsByTeacherNotFoundException(teacherId);
        }
        return applicationService.getAllApprovedApplicationsByTeacher(teacherId);
    }
}
