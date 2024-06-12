package bg.graduationApp.Graduation.App.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="review")
public class Review {
    //Рецензия
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String text;
    private boolean conclusion;
    @OneToOne
    @JoinColumn(name="graduationThesis_id")
   // @JsonIgnore
    @JsonIgnoreProperties("review")
    private GraduationThesis graduationThesis;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    //@JsonIgnore
    @JsonIgnoreProperties("review")
    private Teacher teacher;

    public Review() {
    }

    public Review(Long id, LocalDate date, String text, boolean conclusion, GraduationThesis graduationThesis, Teacher teacher) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.conclusion = conclusion;
        this.graduationThesis = graduationThesis;
        this.teacher = teacher;
    }

    public Review(LocalDate date, String text, boolean conclusion, GraduationThesis graduationThesis, Teacher teacher) {
        this.date = date;
        this.text = text;
        this.conclusion = conclusion;
        this.graduationThesis = graduationThesis;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isConclusion() {
        return conclusion;
    }

    public void setConclusion(boolean conclusion) {
        this.conclusion = conclusion;
    }

    public GraduationThesis getGraduationThesis() {
        return graduationThesis;
    }

    public void setGraduationThesis(GraduationThesis graduationThesis) {
        this.graduationThesis = graduationThesis;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    @Transient
    public Long getGraduationThesisId() {
        return (graduationThesis != null) ? graduationThesis.getId() : null;
    }
    @Transient
    public Long getTeacherId() {
        return (teacher != null) ? teacher.getId() : null;
    }
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", conclusion=" + conclusion +
                ", graduationThesis=" + getId() +
                ", teacher=" + getId() +
                '}';
    }


}
