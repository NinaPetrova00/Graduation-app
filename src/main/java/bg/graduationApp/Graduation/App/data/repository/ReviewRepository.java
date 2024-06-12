package bg.graduationApp.Graduation.App.data.repository;

import bg.graduationApp.Graduation.App.data.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Справка за: Броят на студените, които са получили отрицателна рецензия на дипломна работа.
    Long countByConclusion(boolean conclusion);
}
