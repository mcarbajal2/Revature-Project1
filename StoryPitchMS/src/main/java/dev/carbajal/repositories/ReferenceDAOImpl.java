package dev.carbajal.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.carbajal.models.Reference;
import dev.carbajal.utils.HibernateUtil;

public class ReferenceDAOImpl implements ReferenceDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Reference> getAllReferences() {
		
		Session s = HibernateUtil.getSession();
		List<Reference> r = null;
		
		try {
			
			r = s.createQuery("from reference").list();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}

//	@Override
//	public List<Reference> getAllGenresByStory(String storyType) {
//
//		return null;
//	}

	@Override
	public Reference getReference(String genre, String storyType) {
		
		Session s = HibernateUtil.getSession();
		Reference r = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reference> cr = cb.createQuery(Reference.class);
			Root<Reference> root = cr.from(Reference.class);
			
			Predicate p1 = cb.equal(root.get("genre"), genre);
			Predicate p2 = cb.equal(root.get("story_type"), storyType);
			
			cr.select(root).where(cb.and(p1, p2));

			r = s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}
}
