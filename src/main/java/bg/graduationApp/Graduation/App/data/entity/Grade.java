package bg.graduationApp.Graduation.App.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    private Integer gradeMark; //2-6
    public Grade() {
    }

    public Grade(Long id, Student student, Integer gradeMark) {
        this.id = id;
        this.student = student;
        this.gradeMark = gradeMark;
    }

    public Grade(Student student, Integer gradeMark) {
        this.student = student;
        this.gradeMark = gradeMark;
    }

    public Grade(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGradeMark() {
        return gradeMark;
    }

    public void setGradeMark(Integer gradeMark) {
        this.gradeMark = gradeMark;
    }

    @Transient
    public Long getStudentId() {
        return (student != null) ? student.getId() : null;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", student=" + student.getId()+
                ", gradeMark=" + gradeMark +
                '}';
    }
}
