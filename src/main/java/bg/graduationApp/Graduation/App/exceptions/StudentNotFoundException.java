package bg.graduationApp.Graduation.App.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long studentId) {
        super("Student with id " + studentId + " does not exist!");
    }

    public StudentNotFoundException(String email) {
        super("Student with email " + email + " does not exist!");
    }
}
