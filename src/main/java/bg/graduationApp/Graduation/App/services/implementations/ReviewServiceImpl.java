package bg.graduationApp.Graduation.App.services.implementations;

import bg.graduationApp.Graduation.App.data.entity.Review;
import bg.graduationApp.Graduation.App.data.repository.GraduationThesisRepository;
import bg.graduationApp.Graduation.App.data.repository.ReviewRepository;
import bg.graduationApp.Graduation.App.data.repository.TeacherRepository;
import bg.graduationApp.Graduation.App.exceptions.GraduationThesisNotFoundException;
import bg.graduationApp.Graduation.App.exceptions.TeacherNotFoundException;
import bg.graduationApp.Graduation.App.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final TeacherRepository teacherRepository;
    private final GraduationThesisRepository graduationThesisRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, TeacherRepository teacherRepository, GraduationThesisRepository graduationThesisRepository) {
        this.reviewRepository = reviewRepository;
        this.teacherRepository = teacherRepository;
        this.graduationThesisRepository = graduationThesisRepository;
    }


    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void addNewReview(Review review, Long graduationThesisId, Long teacherId) {
        boolean graduationThesisExists = graduationThesisRepository.existsById(graduationThesisId);
        boolean teacherExists = teacherRepository.existsById(teacherId);

        if (!graduationThesisExists) {
            throw new GraduationThesisNotFoundException(graduationThesisId);
        }
        if (!teacherExists) {
            throw new TeacherNotFoundException(teacherId);
        }

        reviewRepository.save(review);
    }

    @Override
    public Long studentCountByNegativeConclusion() {
        return reviewRepository.countByConclusion(false);
    }
}
