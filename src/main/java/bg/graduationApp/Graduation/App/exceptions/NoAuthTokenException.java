package bg.graduationApp.Graduation.App.exceptions;

public class NoAuthTokenException extends RuntimeException {

    public NoAuthTokenException() {
        super("You are unauthorized!");
    }
}
