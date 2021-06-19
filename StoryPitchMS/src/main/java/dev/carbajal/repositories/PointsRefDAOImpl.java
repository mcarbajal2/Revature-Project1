package dev.carbajal.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.carbajal.models.PointsRef;
import dev.carbajal.utils.HibernateUtil;

public class PointsRefDAOImpl implements PointsRefDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<PointsRef> getAllPointsRef() {
		
		Session s = HibernateUtil.getSession();
		List<PointsRef> pRef = null;
		
		try {
			
			pRef = s.createQuery("from points_ref").list();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return pRef;
	}

	@Override
	public PointsRef getPointsRef(String storyType, int points) {
		
		Session s = HibernateUtil.getSession();
		PointsRef pRef = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<PointsRef> cr = cb.createQuery(PointsRef.class);
			Root<PointsRef> root = cr.from(PointsRef.class);
			
			Predicate p1 = cb.equal(root.get("story_type"), storyType);
			Predicate p2 = cb.equal(root.get("p_amount"), points);
			
			cr.select(root).where(cb.and(p1, p2));

			pRef = s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return pRef;
	}
}
