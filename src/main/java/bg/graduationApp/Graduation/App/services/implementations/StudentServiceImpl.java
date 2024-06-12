package bg.graduationApp.Graduation.App.services.implementations;

import bg.graduationApp.Graduation.App.data.entity.Student;
import bg.graduationApp.Graduation.App.data.repository.StudentRepository;
import bg.graduationApp.Graduation.App.exceptions.EmailTakenException;
import bg.graduationApp.Graduation.App.exceptions.FacultyNumberTakenException;
import bg.graduationApp.Graduation.App.exceptions.NoAuthTokenException;
import bg.graduationApp.Graduation.App.exceptions.StudentNotFoundException;
import bg.graduationApp.Graduation.App.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            throw new NoAuthTokenException();
//        }
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        Optional<Student> studentByFNumber = studentRepository.findStudentByFacultyNumber(student.getFacultyNumber());

        if (studentByEmail.isPresent()) {
            throw new EmailTakenException(student.getEmail());
        }


        if (studentByFNumber.isPresent()) {
            throw new FacultyNumberTakenException(student.getFacultyNumber());
        }

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);

        if (!studentExists) {
            throw new StudentNotFoundException(studentId);
        }

        studentRepository.deleteById(studentId);
    }

    @Override
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));

//        if (name != null &&
//                name.length() > 0 &&
//                !Objects.equals(student.getFirstName(), name)) {
//            student.getFirstName(name);
//        }
//        if (email != null &&
//                email.length() > 0 &&
//                !Objects.equals(student.getEmail(), email)) {
//            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
//
//            if (studentOptional.isPresent()) {
//                throw new IllegalStateException("email taken");
//            }

        student.setEmail(email);
    }

    @Override
    public void findStudentByEmail(String email) {
        Optional<Student> student = studentRepository.findStudentByEmail(email);

        if (student.isEmpty()) {
            throw new StudentNotFoundException(email);
        }

//        return student.map(student1 -> {
//            student1.getFirstName(),
//            student1.getEmail(),
//            return
//        })
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findStudentById(id);
        // studentRepository.existsById(id);
    }

    @Override
    public Optional<Student> findStudentByFacultyNumber(String facultyNumber) {
        return studentRepository.findStudentByFacultyNumber(facultyNumber);
    }


}

