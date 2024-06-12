package bg.graduationApp.Graduation.App.services.implementations;

import bg.graduationApp.Graduation.App.data.entity.Teacher;
import bg.graduationApp.Graduation.App.data.repository.TeacherRepository;
import bg.graduationApp.Graduation.App.exceptions.EmailTakenException;
import bg.graduationApp.Graduation.App.exceptions.TeacherNotFoundException;
import bg.graduationApp.Graduation.App.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(teacher.getEmail());

        if (teacherOptional.isPresent()) {
            throw new EmailTakenException(teacher.getEmail());
        }

        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepository.existsById(teacherId);

        if (!exists) {
            throw new TeacherNotFoundException(teacherId);
        }
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public void updateTeacher(Long teacherId, String firstName, String lastName, String email) {

    }
}
