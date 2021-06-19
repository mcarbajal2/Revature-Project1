package dev.carbajal.repositories;

import java.util.List;

import dev.carbajal.models.Stories;

public interface StoriesDAO {
	
	// CRUD //
	
	// Create
	
	public Stories addStory(Stories st);
	
	// Read
	
	public Stories getStoryById(String id);
	
	public List<Stories> getAllStoriesByGenre(String genre);
	
	// Update
	
	public void updateStory(Stories st);
	
	// Delete
	
	public void deleteStory(Stories st);

}
