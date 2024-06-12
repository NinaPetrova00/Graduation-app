package bg.graduationApp.Graduation.App.web.controller;

import bg.graduationApp.Graduation.App.data.entity.Student;
import bg.graduationApp.Graduation.App.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    private final StudentService studentService;

    //the student service should be autowired for us and then injected to the constructor
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping("/hello")
//    @PreAuthorize("hasRole('client_student')")
//    public String hello() {
//        return "Hello from client_student";
//    }
//
//    @GetMapping("/hello2")
//    @PreAuthorize("hasRole('client_teacher')")
//    public String hello2() {
//        return "Hello from client_teacher";
//    }


    // read all students
    @GetMapping("/allStudents")
    @PreAuthorize("hasRole('client_teacher')")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    //PUT - create/add new student
    @PostMapping("/create")
    public void addNewStudent(@RequestBody Student student) {
        //take the request body and map it to the student
        studentService.addNewStudent(student);
    }

    // DELETE
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    //UPDATE
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

    // @PostMapping("/login")

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }
}
