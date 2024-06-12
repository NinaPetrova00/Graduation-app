package bg.graduationApp.Graduation.App.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String facultyNumber;
    private String email;
    @Enumerated
    private Department department;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private Application application;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private GraduationThesis graduationThesis;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private Grade grade;

    public Student() {
    }


    public Student(String firstName, String lastName, String facultyNumber, String email, Department department, Application application, Role role, GraduationThesis graduationThesis, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyNumber = facultyNumber;
        this.email = email;
        this.department = department;
        this.application = application;
        this.role = role;
        this.graduationThesis = graduationThesis;
        this.grade = grade;
    }

    public Student(Long id, String firstName, String lastName, String facultyNumber, String email, Department department, Application application, Role role, GraduationThesis graduationThesis, Grade grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyNumber = facultyNumber;
        this.email = email;
        this.department = department;
        this.application = application;
        this.role = role;
        this.graduationThesis = graduationThesis;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public GraduationThesis getGraduationThesis() {
        return graduationThesis;
    }

    public void setGraduationThesis(GraduationThesis graduationThesis) {
        this.graduationThesis = graduationThesis;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", facultyNumber='" + facultyNumber + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", application=" + application +
                ", role=" + role +
                ", graduationThesis=" + graduationThesis +
                ", grade=" + grade +
                '}';
    }
}
