package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Reviews;
import dev.carbajal.repositories.ReviewsDAO;
import dev.carbajal.repositories.ReviewsDAOImpl;

public class ReviewsServicesImpl implements ReviewsServices {
	
	private ReviewsDAO rd = new ReviewsDAOImpl();

	@Override
	public Reviews addReview(Reviews r) {

		return rd.addReview(r);
	}

	@Override
	public List<Reviews> getAllReviews() {

		return rd.getAllReviews();
	}

	@Override
	public List<Reviews> getAllReviewsByStoryId(int storyId) {

		return rd.getAllReviewsByStoryId(storyId);
	}

	@Override
	public List<Reviews> getAllReviewsByEditorId(int editorId) {

		return rd.getAllReviewsByEditorId(editorId);
	}

	@Override
	public List<Reviews> getAllReviewDecisionsById(int storyId, String reviewType) {

		return rd.getAllReviewDecisionsById(storyId, reviewType);
	}

	@Override
	public Reviews getReviewById(int storyId, int editorId, String reviewType) {

		return rd.getReviewById(storyId, editorId, reviewType);
	}

	@Override
	public void updateReviewPriority(Reviews r) {
		
		rd.updateReviewPriority(r);
	}

	@Override
	public void deleteReview(Reviews r) {
		
		rd.deleteReview(r);
	}
}
