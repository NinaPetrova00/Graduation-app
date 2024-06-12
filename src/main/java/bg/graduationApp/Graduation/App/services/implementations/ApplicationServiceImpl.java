package bg.graduationApp.Graduation.App.services.implementations;

import bg.graduationApp.Graduation.App.data.entity.Application;
import bg.graduationApp.Graduation.App.data.entity.Teacher;
import bg.graduationApp.Graduation.App.data.repository.ApplicationRepository;
import bg.graduationApp.Graduation.App.data.repository.StudentRepository;
import bg.graduationApp.Graduation.App.data.repository.TeacherRepository;
import bg.graduationApp.Graduation.App.exceptions.ApplicationExistsException;
import bg.graduationApp.Graduation.App.exceptions.ApplicationNotFoundException;
import bg.graduationApp.Graduation.App.exceptions.StudentNotFoundException;
import bg.graduationApp.Graduation.App.exceptions.TeacherNotFoundException;
import bg.graduationApp.Graduation.App.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void addNewApplication(Application application, Long studentId, Long teacherId) {
        boolean studentExists = studentRepository.existsById(studentId);
        boolean teacherExists = teacherRepository.existsById(teacherId);
        Optional<Application> applicationExists = applicationRepository.findApplicationByStudent_Id(studentId);

        if (!studentExists) {
            throw new StudentNotFoundException(studentId);
        }
        if (!teacherExists) {
            throw new TeacherNotFoundException(teacherId);
        }
        if (applicationExists.isPresent()) {
            throw new ApplicationExistsException(studentId);
        }

        applicationRepository.save(application);
    }

    @Override
    public List<Application> getAllApplications() {

        return applicationRepository.findAll();

    }

    @Override
    public void approveApplication(Long applicationId, boolean isApproved) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ApplicationNotFoundException(applicationId));

        application.setApproved(isApproved);
        applicationRepository.save(application);
    }

    @Override
    public Optional<Application> findApplicationByStudentId(Long studentId) {

        if (applicationRepository.findApplicationByStudent_Id(studentId).isPresent()) {
            throw new ApplicationExistsException(studentId);
        }
        return applicationRepository.findApplicationByStudent_Id(studentId);

    }

    @Override
    public List<Application> getAllApprovedApplications() {
        return applicationRepository.findAllByIsApproved(true);
    }

    @Override
    public List<Application> getAllApplicationsByTopicContainingString(String topicContaining) {
        return applicationRepository.findAllApplicationsByTopicContaining(topicContaining);
    }

    @Override
    public List<Application> getAllApprovedApplicationsByTeacher(Long teacherId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        return applicationRepository.findAllByTeacherAndIsApproved(teacher, true);
    }
}
