package bg.graduationApp.Graduation.App.exceptions;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(Long applicationId) {
        super("Application with id " + applicationId + " does not exist!");
    }
}
