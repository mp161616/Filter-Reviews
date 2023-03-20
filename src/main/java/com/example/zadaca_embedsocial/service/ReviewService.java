package com.example.zadaca_embedsocial.service;

import com.example.zadaca_embedsocial.model.Review;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private List<Review> reviews = new ArrayList<>();

    @PostConstruct
    private void loadReviews() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = getClass().getResourceAsStream("/reviews.json");
            TypeReference<List<Review>> typeReference = new TypeReference<List<Review>>() {};
            reviews = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




 public List<Review> getSortedProducts(int rating, String dateOrder, String ratingOrder) {
            Comparator<Review> comparator = null;

            if ("ascending".equals(ratingOrder) && "ascending".equals(dateOrder)) {
                comparator = Comparator.comparing(Review::getRating)
                        .thenComparing(Review::getReviewCreatedOnDate);
            } else if ("ascending".equals(ratingOrder) && "descending".equals(dateOrder)) {
                comparator = Comparator.comparing(Review::getRating)
                        .thenComparing(Review::getReviewCreatedOnDate, Comparator.reverseOrder());
            } else if ("descending".equals(ratingOrder) && "ascending".equals(dateOrder)) {
                comparator = Comparator.comparing(Review::getRating, Comparator.reverseOrder())
                        .thenComparing(Review::getReviewCreatedOnDate);
            } else if ("descending".equals(ratingOrder) && "descending".equals(dateOrder)) {
                comparator = Comparator.comparing(Review::getRating, Comparator.reverseOrder())
                        .thenComparing(Review::getReviewCreatedOnDate, Comparator.reverseOrder());
            }
            if (comparator != null) {
                reviews.sort(comparator);
            }
            return reviews.stream().filter(p -> p.getRating() >= rating)
                    .collect(Collectors.toList());
        }




}
