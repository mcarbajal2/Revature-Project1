package dev.carbajal.repositories;

import java.util.List;

import dev.carbajal.models.Reviews;

public interface ReviewsDAO {
	
	// CRUD //
	
	// Create
	
	public Reviews addReview(Reviews r);
	
	// Read
	
	public List<Reviews> getAllReviews();
	
	public List<Reviews> getAllReviewsByStoryId(int storyId);
	
	public List<Reviews> getAllReviewsByEditorId(int editorId);
	
	public List<Reviews> getAllReviewDecisionsById(int storyId, String reviewType);
	
	public Reviews getReviewById(int storyId, int editorId, String reviewType);
	
//	public boolean checkIfEditorReviewExists(int storyId, int editorId, String reviewType);
	
//	public int getReviewCountById(int storyId, String reviewType);
	
	// Update
	
	public void updateReviewPriority(Reviews r);
	
	// Delete
	
	public void deleteReview(Reviews r);

}
