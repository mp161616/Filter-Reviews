package com.example.zadaca_embedsocial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    private int id;

    private String reviewId;
    private int rating;
    private String reviewText;
    public String reviewCreatedOnDate;

    public Review() {
    }

    public Review(int id, String reviewId, int rating, String reviewText, String reviewCreatedOnDate) {
        this.id = id;
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.reviewCreatedOnDate = reviewCreatedOnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewCreatedOnDate() {
        return reviewCreatedOnDate;
    }

    public void setReviewCreatedOnDate(String reviewCreatedOnDate) {
        this.reviewCreatedOnDate = reviewCreatedOnDate;
    }
}
