package bg.graduationApp.Graduation.App.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<Object> handleTeacherNotFoundException(TeacherNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<Object> handleApplicationNotFoundException(ApplicationNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(ApplicationNotApprovedException.class)
    public ResponseEntity<Object> handleApplicationNotApprovedFoundException(ApplicationNotApprovedException exception) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(exception.getMessage());
    }

    @ExceptionHandler(GraduationThesisNotFoundException.class)
    public ResponseEntity<Object> handleGraduationThesisNotFoundException(GraduationThesisNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(EmailTakenException.class)
    public ResponseEntity<Object> handleEmailTakenException(EmailTakenException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(FacultyNumberTakenException.class)
    public ResponseEntity<Object> handleFacultyNumberTakenException(FacultyNumberTakenException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(NoAuthTokenException.class)
    public ResponseEntity<Object> handleNoAuthTokenException(NoAuthTokenException exception) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(exception.getMessage());
    }

    @ExceptionHandler(GraduationThesisExistsException.class)
    public ResponseEntity<Object> handleGraduationThesisExistsException(GraduationThesisExistsException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(ApplicationExistsException.class)
    public ResponseEntity<Object> handleApplicationExistsException(ApplicationExistsException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(StudentDoesNotHaveApplicationException.class)
    public ResponseEntity<Object> handleStudentDoesNotHaveApplicationException(StudentDoesNotHaveApplicationException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(ApplicationsByTeacherNotFoundException.class)
    public ResponseEntity<Object> handleApplicationsByTeacherNotFoundException(ApplicationsByTeacherNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

}
