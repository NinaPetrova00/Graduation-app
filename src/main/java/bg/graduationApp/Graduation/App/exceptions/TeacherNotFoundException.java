package bg.graduationApp.Graduation.App.exceptions;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(Long teacherId) {
        super("Teacher with id " + teacherId + " does not exist!");
    }

    public TeacherNotFoundException(String email) {
        super("Teacher with email " + email + " does not exist!");
    }
}
