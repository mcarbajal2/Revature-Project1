package dev.carbajal.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.carbajal.models.Stories;
import dev.carbajal.utils.HibernateUtil;

public class StoriesDAOImpl implements StoriesDAO {

	@Override
	public Stories addStory(Stories st) {
		
		Session s = HibernateUtil.getSession();
		
		try {
			
			s.beginTransaction();
			s.save(st);
			s.getTransaction().commit();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			s.getTransaction().rollback();
			
		} finally {
			
			s.close();
		}
		
		return st;
	}

	@Override
	public Stories getStoryById(String id) {

		Session s = HibernateUtil.getSession();
		Stories st = null;

		try {

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Stories> cr = cb.createQuery(Stories.class);
			Root<Stories> root = cr.from(Stories.class);

			cr.select(root).where(cb.equal(root.get("id"), id));

			st = (Stories) s.createQuery(cr);

		} catch (HibernateException e) {

			e.printStackTrace();

		} finally {

			s.close();
		}

		return st;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stories> getAllStoriesByGenre(String genre) {
		
		Session s = HibernateUtil.getSession();
		List<Stories> st = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Stories> cr = cb.createQuery(Stories.class);
			Root<Stories> root = cr.from(Stories.class);
			
			Predicate p = cb.equal(root.get("genre"), genre);
			
			cr.select(root).where(cb.and(p));

			st = (List<Stories>) s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return st;
	}

	@Override
	public void updateStory(Stories st) {

		Session s = HibernateUtil.getSession();
		Transaction tx = null;

		try {

			tx = s.beginTransaction();
			s.save(st);
			tx.commit();

		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			s.close();
		}
	}

	@Override
	public void deleteStory(Stories st) {

		Session s = HibernateUtil.getSession();
		Transaction tx = null;

		try {

			tx = s.beginTransaction();
			s.delete(st);
			tx.commit();

		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			s.close();
		}
	}
}
