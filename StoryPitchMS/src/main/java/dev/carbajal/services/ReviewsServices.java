package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Reviews;

public interface ReviewsServices {
	
	public Reviews addReview(Reviews r);
	
	public List<Reviews> getAllReviews();
	
	public List<Reviews> getAllReviewsByStoryId(int storyId);
	
	public List<Reviews> getAllReviewsByEditorId(int editorId);
	
	public List<Reviews> getAllReviewDecisionsById(int storyId, String reviewType);
	
	public Reviews getReviewById(int storyId, int editorId, String reviewType);
	
	public void updateReviewPriority(Reviews r);
	
	public void deleteReview(Reviews r);

}
