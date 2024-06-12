package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.Application;
import bg.graduationApp.Graduation.App.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    //void approveApplication(Long applicationId);

    Optional<Application> findApplicationByStudent_Id(Long studentId);

    //	Справки за: Всички одобрени задания за дипломна работа.
    List<Application> findAllByIsApproved(boolean isApproved);

    // Справки за: Всички теми на дипломни работи, които в заглавието си съдържат определен символен низ.
    List<Application> findAllApplicationsByTopicContaining(String topicContaining);

    // Справки за: Всички одобрени задания за дипломна работа, на които е ръководител определен преподавател
   // List<Application> findAllByTeacherAndIsApproved(Long teacherId);
    List<Application> findAllByTeacherAndIsApproved(Optional<Teacher> teacher, boolean isApproved);
}
