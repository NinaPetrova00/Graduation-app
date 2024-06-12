package bg.graduationApp.Graduation.App.services;

import bg.graduationApp.Graduation.App.data.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    void addNewReview(Review review, Long graduationThesisId, Long teacherId);

    // Справка за: Броят на студените, които са получили отрицателна рецензия на дипломна работа.
    Long studentCountByNegativeConclusion();
}
