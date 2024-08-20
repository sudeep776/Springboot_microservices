package com.microservices.SpringbootMcs.review;

import com.microservices.SpringbootMcs.company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isSaved = reviewService.addReview(companyId,review);
        if(isSaved) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }return new ResponseEntity<>("Review Not Saved",HttpStatus.OK);
    }

    @GetMapping("reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,@RequestBody Review review){
        boolean flag = reviewService.updateReview(companyId,reviewId,review);
        if(flag) return new ResponseEntity<>("Review updated",HttpStatus.OK);
        else return new ResponseEntity<>("Review not updated",HttpStatus.OK);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean flag = reviewService.deleteReview(companyId,reviewId);
        if(flag){
            return new ResponseEntity<>("Review deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not deleted",HttpStatus.OK);
        }
    }
}
