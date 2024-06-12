package bg.graduationApp.Graduation.App.services;

import bg.graduationApp.Graduation.App.data.entity.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    void addNewApplication(Application application, Long studentId, Long teacherId);

    List<Application> getAllApplications();

    void approveApplication(Long applicationId, boolean isApproved);

    Optional<Application> findApplicationByStudentId(Long studentId);

    //	Справки за: Всички одобрени задания за дипломна работа.
    List<Application> getAllApprovedApplications();

    // Справки за: Всички теми на дипломни работи, които в заглавието си съдържат определен символен низ.
    List<Application> getAllApplicationsByTopicContainingString(String topicContaining);

    // Справки за: Всички одобрени задания за дипломна работа, на които е ръководител определен преподавател
    List<Application> getAllApprovedApplicationsByTeacher(Long teacherId);
}
