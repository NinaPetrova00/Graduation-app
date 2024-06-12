package bg.graduationApp.Graduation.App.services.implementations;

import bg.graduationApp.Graduation.App.data.entity.Grade;
import bg.graduationApp.Graduation.App.data.repository.GradeRepository;
import bg.graduationApp.Graduation.App.data.repository.StudentRepository;
import bg.graduationApp.Graduation.App.exceptions.StudentNotFoundException;
import bg.graduationApp.Graduation.App.services.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    public GradeServiceImpl(GradeRepository gradeRepository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void addNewGrade(Grade grade, Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new StudentNotFoundException(studentId);
        }

        System.out.println("test----" + studentId);
        gradeRepository.save(grade);
    }
}
