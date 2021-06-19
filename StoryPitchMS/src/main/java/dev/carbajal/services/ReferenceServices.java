package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Reference;

public interface ReferenceServices {
	
	public List<Reference> getAllReferences();
	
	public Reference getReference(String genre, String storyType);

}
