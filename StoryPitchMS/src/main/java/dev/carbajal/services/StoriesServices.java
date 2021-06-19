package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Stories;

public interface StoriesServices {
	
	public Stories addStory(Stories st);
	
	public Stories getStoryById(String id);
	
	public List<Stories> getAllStoriesByGenre(String genre);
	
	public void updateStory(Stories st);
	
	public void deleteStory(Stories st);

}
