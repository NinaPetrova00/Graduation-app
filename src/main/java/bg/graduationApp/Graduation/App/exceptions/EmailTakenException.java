package bg.graduationApp.Graduation.App.exceptions;

public class EmailTakenException extends RuntimeException {

    public EmailTakenException(String email) {
        super("Email " + email + " is already taken!");
    }
}
