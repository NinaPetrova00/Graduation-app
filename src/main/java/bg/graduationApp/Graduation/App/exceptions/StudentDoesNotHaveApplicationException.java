package bg.graduationApp.Graduation.App.exceptions;

public class StudentDoesNotHaveApplicationException extends RuntimeException{

    public StudentDoesNotHaveApplicationException(Long studentId){
        super("Student with id = "+ studentId + " does not have an application!");
    }
}
