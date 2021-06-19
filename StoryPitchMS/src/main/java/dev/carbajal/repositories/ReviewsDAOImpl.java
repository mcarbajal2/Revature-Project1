package dev.carbajal.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.carbajal.models.Reviews;
import dev.carbajal.utils.HibernateUtil;

public class ReviewsDAOImpl implements ReviewsDAO {

	@Override
	public Reviews addReview(Reviews r) {
		
		Session s = HibernateUtil.getSession();
		
		try {
			
			s.beginTransaction();
			s.save(r);
			s.getTransaction().commit();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			s.getTransaction().rollback();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reviews> getAllReviews() {
		
		Session s = HibernateUtil.getSession();
		List<Reviews> r = null;
		
		try {
			
			r = s.createQuery("from reference").list();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reviews> getAllReviewsByStoryId(int storyId) {
		
		Session s = HibernateUtil.getSession();
		List<Reviews> r = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reviews> cr = cb.createQuery(Reviews.class);
			Root<Reviews> root = cr.from(Reviews.class);
			
			Predicate p = cb.equal(root.get("story_id"), storyId);
			
			cr.select(root).where(cb.and(p));

			r = (List<Reviews>) s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reviews> getAllReviewsByEditorId(int editorId) {
		
		Session s = HibernateUtil.getSession();
		List<Reviews> r = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reviews> cr = cb.createQuery(Reviews.class);
			Root<Reviews> root = cr.from(Reviews.class);
			
			Predicate p = cb.equal(root.get("editor_id"), editorId);
			
			cr.select(root).where(cb.and(p));

			r = (List<Reviews>) s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reviews> getAllReviewDecisionsById(int storyId, String reviewType) {
		
		Session s = HibernateUtil.getSession();
		List<Reviews> r = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reviews> cr = cb.createQuery(Reviews.class);
			Root<Reviews> root = cr.from(Reviews.class);
			
			Predicate p1 = cb.equal(root.get("story_id"), storyId);
			Predicate p2 = cb.equal(root.get("review_type"), reviewType);
			
			cr.select(root).where(cb.and(p1, p2));

			r = (List<Reviews>) s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}

	@Override
	public Reviews getReviewById(int storyId, int editorId, String reviewType) {
		
		Session s = HibernateUtil.getSession();
		Reviews r = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reviews> cr = cb.createQuery(Reviews.class);
			Root<Reviews> root = cr.from(Reviews.class);
			
			Predicate p1 = cb.equal(root.get("story_id"), storyId);
			Predicate p2 = cb.equal(root.get("editor_id"), editorId);
			Predicate p3 = cb.equal(root.get("review_type"), reviewType);
			
			cr.select(root).where(cb.and(p1, p2, p3));

			r = s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return r;
	}

	@Override
	public void updateReviewPriority(Reviews r) {

		Session s = HibernateUtil.getSession();
		Transaction tx = null;

		try {

			tx = s.beginTransaction();
			s.save(r);
			tx.commit();

		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			s.close();
		}
	}

	@Override
	public void deleteReview(Reviews r) {

		Session s = HibernateUtil.getSession();
		Transaction tx = null;

		try {

			tx = s.beginTransaction();
			s.delete(r);
			tx.commit();

		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			s.close();
		}
	}
}
