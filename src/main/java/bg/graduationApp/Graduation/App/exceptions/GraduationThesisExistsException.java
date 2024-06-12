package bg.graduationApp.Graduation.App.exceptions;

public class GraduationThesisExistsException extends RuntimeException {
    public GraduationThesisExistsException(Long studentId) {
        super("Student with id = " + studentId + " already has an graduation thesis!");
    }
}
