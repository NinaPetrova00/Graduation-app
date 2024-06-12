package bg.graduationApp.Graduation.App.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "graduationThesis")
public class GraduationThesis {
    //Дипломнa теза - качва се от студента
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String header;
    private String text;
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToOne(mappedBy = "graduationThesis", cascade = CascadeType.ALL)
    private Review review;

    public GraduationThesis() {
    }

    public GraduationThesis(Long id, String header, String text, LocalDate date, Student student, Review review) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.date = date;
        this.student = student;
        this.review = review;
    }

    public GraduationThesis(String header, String text, LocalDate date, Student student, Review review) {
        this.header = header;
        this.text = text;
        this.date = date;
        this.student = student;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Transient
    public Long getStudentId() {
        return (student != null) ? student.getId() : null;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "GraduationThesis{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", student=" + student.getId() +
                ", review=" + review +
                '}';
    }
}
