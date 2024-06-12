package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.Application;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ApplicationRepositoryTest {

    @Autowired
    private ApplicationRepository applicationRepository;


    @AfterEach
    void tearDown() {
        // delete the test data after the test
        applicationRepository.deleteAll();
    }

    @Test
    void findApplicationByStudent_Id() {
        Application application = new Application();

        Optional<Application> applicationExists = applicationRepository.findApplicationByStudent_Id(application.getStudentId());
        assertTrue(applicationExists.isPresent());
    }

    @Test
    void findAllByIsApproved() {
    }

    @Test
    void findAllApplicationsByTopicContaining() {
    }

    @Test
    void findAllByTeacherAndIsApproved() {
    }
}