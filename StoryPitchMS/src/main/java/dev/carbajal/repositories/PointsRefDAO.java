package dev.carbajal.repositories;

import java.util.List;

import dev.carbajal.models.PointsRef;

public interface PointsRefDAO {
	
	// CRUD //
	
	// Create - nothing to do here, point values are static
	
	// Read
	
	public List<PointsRef> getAllPointsRef();
	
	public PointsRef getPointsRef(String storyType, int points);
	
	// Update  - nothing to do here, point values are static
	
	// Delete  - nothing to do here, point values are static

}
