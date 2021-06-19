package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.PointsRef;

public interface PointsRefServices {
	
	public List<PointsRef> getAllPointsRef();
	
	public PointsRef getPointsRef(String storyType, int points);

}
