package com.example.zadaca_embedsocial.web;

import com.example.zadaca_embedsocial.model.Review;
import com.example.zadaca_embedsocial.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @GetMapping("/reviews")
    public String listReviewsByRating(Model model,
                                      @RequestParam(name = "rating", defaultValue = "1") int rating,
                                      @RequestParam(name = "dateOrder", defaultValue = "ascending") String dateOrder,
                                      @RequestParam(name = "ratingOrder", defaultValue = "ascending") String ratingOrder) {


        List<Review> reviews = reviewService.getSortedProducts(rating, dateOrder, ratingOrder);
        model.addAttribute("reviews", reviews);
        model.addAttribute("ratings", Arrays.asList(1, 2, 3, 4, 5));
        model.addAttribute("dateOrder", dateOrder);
        model.addAttribute("ratingOrder", ratingOrder);
        model.addAttribute("selectedRating", rating);
        return "search";
    }
}



