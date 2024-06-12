package bg.graduationApp.Graduation.App.exceptions;

public class FacultyNumberTakenException extends RuntimeException {

    public FacultyNumberTakenException(String facultyNumber) {

        super("Faculty number = " + facultyNumber + " already taken for another student!");
    }
}

