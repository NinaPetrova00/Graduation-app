package bg.graduationApp.Graduation.App.web.controller;

import bg.graduationApp.Graduation.App.data.entity.Review;
import bg.graduationApp.Graduation.App.services.ReviewService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/allReviews")
    @PreAuthorize("hasRole('client_teacher')")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('client_teacher')")
    public void createNewReview(@RequestBody Review review) {
        Long graduationThesisId = review.getGraduationThesisId();
        Long teacherId = review.getTeacherId();

        reviewService.addNewReview(review, graduationThesisId, teacherId);
    }

    @GetMapping("/studentsWithNegativeConclusion")
    public long studentsCount() {
        return reviewService.studentCountByNegativeConclusion();
    }
}
