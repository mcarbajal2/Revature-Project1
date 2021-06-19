package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Stories;
import dev.carbajal.repositories.StoriesDAO;
import dev.carbajal.repositories.StoriesDAOImpl;

public class StoriesServicesImpl implements StoriesServices {
	
	private StoriesDAO sd = new StoriesDAOImpl();

	@Override
	public Stories addStory(Stories st) {

		return sd.addStory(st);
	}

	@Override
	public Stories getStoryById(String id) {

		return sd.getStoryById(id);
	}

	@Override
	public List<Stories> getAllStoriesByGenre(String genre) {

		return sd.getAllStoriesByGenre(genre);
	}

	@Override
	public void updateStory(Stories st) {
		
		sd.updateStory(st);
	}

	@Override
	public void deleteStory(Stories st) {
		
		sd.deleteStory(st);
	}
}
