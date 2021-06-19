package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.PointsRef;
import dev.carbajal.repositories.PointsRefDAO;
import dev.carbajal.repositories.PointsRefDAOImpl;

public class PointsRefServicesImpl implements PointsRefServices {
	
	private PointsRefDAO prd = new PointsRefDAOImpl();

	@Override
	public List<PointsRef> getAllPointsRef() {

		return prd.getAllPointsRef();
	}

	@Override
	public PointsRef getPointsRef(String storyType, int points) {

		return prd.getPointsRef(storyType, points);
	}
}
