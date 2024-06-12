package bg.graduationApp.Graduation.App.services.implementations;

import bg.graduationApp.Graduation.App.data.entity.Application;
import bg.graduationApp.Graduation.App.data.entity.GraduationThesis;
import bg.graduationApp.Graduation.App.data.entity.Student;
import bg.graduationApp.Graduation.App.data.repository.ApplicationRepository;
import bg.graduationApp.Graduation.App.data.repository.GraduationThesisRepository;
import bg.graduationApp.Graduation.App.data.repository.StudentRepository;
import bg.graduationApp.Graduation.App.exceptions.ApplicationNotApprovedException;
import bg.graduationApp.Graduation.App.exceptions.GraduationThesisExistsException;
import bg.graduationApp.Graduation.App.exceptions.StudentNotFoundException;
import bg.graduationApp.Graduation.App.services.GraduationThesisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GraduationThesisImpl implements GraduationThesisService {

    private final GraduationThesisRepository graduationThesisRepository;
    private final StudentRepository studentRepository;
    private final ApplicationRepository applicationRepository;

    public GraduationThesisImpl(GraduationThesisRepository graduationThesisRepository, StudentRepository studentRepository, ApplicationRepository applicationRepository) {
        this.graduationThesisRepository = graduationThesisRepository;
        this.studentRepository = studentRepository;
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void addNewGraduationThesis(GraduationThesis graduationThesis, Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists) {
            throw new StudentNotFoundException(studentId);
        }

        Optional<Application> application = applicationRepository.findApplicationByStudent_Id(studentId);

        if (application.isPresent() && application.get().isApproved()) {
            // Application is present and approved, save the graduation thesis
            graduationThesisRepository.save(graduationThesis);
        } else {
            throw new ApplicationNotApprovedException(studentId);
        }

        graduationThesisRepository.save(graduationThesis);
    }

    @Override
    public List<GraduationThesis> getAllGraduationTheses() {
        return graduationThesisRepository.findAll();
    }

    @Override
    public Optional<GraduationThesis> findGraduationByStudent_Id(Long studentId) {
        if (graduationThesisRepository.findGraduationByStudent_Id(studentId).isPresent()) {
            throw new GraduationThesisExistsException(studentId);
        }
        return graduationThesisRepository.findGraduationByStudent_Id(studentId);
    }
}
