package bg.graduationApp.Graduation.App.web.controller;

import bg.graduationApp.Graduation.App.data.entity.Student;
import bg.graduationApp.Graduation.App.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Optional;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.security.test.context.support.WithMockUser;
@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @WithMockUser(roles = "client_teacher")
    void getAllStudents_roleTeacher() throws Exception {
        when(studentService.getAllStudents()).thenReturn(Collections.singletonList(new Student()));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/allStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

        verify(studentService, times(1)).getAllStudents();
    }
    @Test
    void getAllStudents_noRole() throws Exception {
        when(studentService.getAllStudents()).thenReturn(Collections.singletonList(new Student()));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/student/allStudents")).andReturn();

        assertEquals(401, mvcResult.getResponse().getStatus()); // Expecting a 403 Forbidden status

        verify(studentService, never()).getAllStudents(); // Ensure the method is not called
    }


    @Test
    @WithMockUser(roles = "client_teacher")
    void addNewStudent_ReturnsCreated() throws Exception {
        Student student = new Student();
        doNothing().when(studentService).addNewStudent(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(studentService, times(1)).addNewStudent(student);

    }

//    @Test
//    void deleteStudent() throws Exception {
//        Long studentId = 1L;
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/student/{studentId}", studentId))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        verify(studentService, times(1)).deleteStudent(studentId);
//    }
    @Test
    void findById() throws Exception {
        Long studentId = 1L;
        Student student = new Student(); // Assuming Student is your entity class

        when(studentService.findStudentById(studentId)).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/{id}", studentId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentId)); // Adjust this based on your entity structure

        verify(studentService, times(1)).findStudentById(studentId);
    }
}