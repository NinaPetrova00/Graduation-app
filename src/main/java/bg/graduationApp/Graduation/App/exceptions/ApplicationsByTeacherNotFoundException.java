package bg.graduationApp.Graduation.App.exceptions;

public class ApplicationsByTeacherNotFoundException extends RuntimeException {

    public ApplicationsByTeacherNotFoundException(Long teacherId) {
        super("Teacher with id = " + teacherId + " does not have any approved applications!");
    }
}
