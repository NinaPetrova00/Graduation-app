package bg.graduationApp.Graduation.App.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name="application")
public class Application {

    //заявление за дипломна работа

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private String purpose;
    private String tasks;
    private String technologies;

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    private boolean isApproved = false;
    public Application() {
    }

    public Application(Long id, String topic, String purpose, String tasks, String technologies, Student student, Teacher teacher, boolean isApproved) {
        this.id = id;
        this.topic = topic;
        this.purpose = purpose;
        this.tasks = tasks;
        this.technologies = technologies;
        this.student = student;
        this.teacher = teacher;
        this.isApproved = isApproved;
    }

    public Application(String topic, String purpose, String tasks, String technologies, Student student, Teacher teacher, boolean isApproved) {
        this.topic = topic;
        this.purpose = purpose;
        this.tasks = tasks;
        this.technologies = technologies;
        this.student = student;
        this.teacher = teacher;
        this.isApproved = isApproved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", purpose='" + purpose + '\'' +
                ", tasks='" + tasks + '\'' +
                ", technologies='" + technologies + '\'' +
                ", student=" + student.getId() +
                ", teacher=" + teacher.getId() +
                ", isApproved=" + isApproved +
                '}';
    }

    @Transient
    public Long getStudentId() {
        return (student != null) ? student.getId() : null;
    }
    @Transient
    public Long getTeacherId() {
        return (teacher != null) ? teacher.getId() : null;
    }
}
