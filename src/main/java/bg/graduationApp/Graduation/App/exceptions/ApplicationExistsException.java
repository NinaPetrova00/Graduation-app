package bg.graduationApp.Graduation.App.exceptions;

public class ApplicationExistsException extends RuntimeException {
    public ApplicationExistsException(Long studentId) {
        super("Student with id = " + studentId + " already has an application!");
    }
}
