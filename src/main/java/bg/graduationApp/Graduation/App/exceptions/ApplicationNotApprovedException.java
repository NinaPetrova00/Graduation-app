package bg.graduationApp.Graduation.App.exceptions;

public class ApplicationNotApprovedException extends RuntimeException {

    public ApplicationNotApprovedException(Long studentId) {
        super("Application is not approved for student with id " + studentId);
    }
}
