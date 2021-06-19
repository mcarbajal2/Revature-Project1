package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Reference;
import dev.carbajal.repositories.ReferenceDAO;
import dev.carbajal.repositories.ReferenceDAOImpl;

public class ReferenceServicesImpl implements ReferenceServices {
	
	private ReferenceDAO rd = new ReferenceDAOImpl();

	@Override
	public List<Reference> getAllReferences() {

		return rd.getAllReferences();
	}

	@Override
	public Reference getReference(String genre, String storyType) {

		return rd.getReference(genre, storyType);
	}
}
