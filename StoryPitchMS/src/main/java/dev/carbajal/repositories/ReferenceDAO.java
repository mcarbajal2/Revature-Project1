package dev.carbajal.repositories;

import java.util.List;

import dev.carbajal.models.Reference;

public interface ReferenceDAO {
	
	// CRUD //
	
	// Create - nothing to do here, reference values are static
	
	// Read
	
	public List<Reference> getAllReferences();
	
//	public List<Reference> getAllGenresByStory(String storyType);
	
	public Reference getReference(String genre, String storyType);
	
	// Update  - nothing to do here, reference values are static
	
	// Delete  - nothing to do here, reference values are static

}
