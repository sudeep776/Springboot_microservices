package com.microservices.reviewms.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review){
        boolean isSaved = reviewService.addReview(companyId,review);
        if(isSaved) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }return new ResponseEntity<>("Review Not Saved",HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(reviewId),HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@RequestBody Review review){
        boolean flag = reviewService.updateReview(reviewId,review);
        if(flag) return new ResponseEntity<>("Review updated",HttpStatus.OK);
        else return new ResponseEntity<>("Review not updated",HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean flag = reviewService.deleteReview(reviewId);
        if(flag){
            return new ResponseEntity<>("Review deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not deleted",HttpStatus.OK);
        }
    }
}
