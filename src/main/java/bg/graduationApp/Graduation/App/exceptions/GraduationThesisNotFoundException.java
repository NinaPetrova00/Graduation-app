package bg.graduationApp.Graduation.App.exceptions;

public class GraduationThesisNotFoundException extends RuntimeException{

    public GraduationThesisNotFoundException(Long graduationThesisId) {
        super("Graduation thesis with id " + graduationThesisId + " does not exist!");
    }
}