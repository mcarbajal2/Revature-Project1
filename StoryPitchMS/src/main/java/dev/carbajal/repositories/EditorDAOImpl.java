package dev.carbajal.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.carbajal.models.Editor;
import dev.carbajal.utils.HibernateUtil;

public class EditorDAOImpl implements EditorDAO {

	@Override
	public Editor addEditor(Editor ed) {
		
		Session s = HibernateUtil.getSession();
		
		try {
			
			s.beginTransaction();
			s.save(ed);
			s.getTransaction().commit();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			s.getTransaction().rollback();
			
		} finally {
			
			s.close();
		}
		
		return ed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Editor> getAllEditorsByCommittee(String committee) {
		
		Session s = HibernateUtil.getSession();
		List<Editor> ed = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Editor> cr = cb.createQuery(Editor.class);
			Root<Editor> root = cr.from(Editor.class);
			
			Predicate p = cb.equal(root.get("genre_committee"), committee);
			
			cr.select(root).where(cb.and(p));

			ed = (List<Editor>) s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return ed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Editor> getEditorsByLogin(String username, String password) {
		
		Session s = HibernateUtil.getSession();
		List<Editor> ed = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Editor> cr = cb.createQuery(Editor.class);
			Root<Editor> root = cr.from(Editor.class);
			
			Predicate p1 = cb.equal(root.get("username"), username);
			Predicate p2 = cb.equal(root.get("password"), password);
			
			cr.select(root).where(cb.and(p1, p2));

			ed = (List<Editor>) s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return ed;
	}

	@Override
	public Editor getEditor(String username, String committee) {
		
		Session s = HibernateUtil.getSession();
		Editor ed = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Editor> cr = cb.createQuery(Editor.class);
			Root<Editor> root = cr.from(Editor.class);
			
			Predicate p1 = cb.equal(root.get("username"), username);
			Predicate p2 = cb.equal(root.get("password"), committee);
			
			cr.select(root).where(cb.and(p1, p2));

			ed = s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return ed;
	}

	@Override
	public Editor getEditorById(int editorId) {

		Session s = HibernateUtil.getSession();
		Editor ed = null;

		try {

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Editor> cr = cb.createQuery(Editor.class);
			Root<Editor> root = cr.from(Editor.class);

			cr.select(root).where(cb.equal(root.get("id"), editorId));

			ed = (Editor) s.createQuery(cr);

		} catch (HibernateException e) {

			e.printStackTrace();

		} finally {

			s.close();
		}

		return ed;
	}

	@Override
	public void updateEditor(Editor ed) {

		Session s = HibernateUtil.getSession();
		Transaction tx = null;

		try {

			tx = s.beginTransaction();
			s.save(ed);
			tx.commit();

		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			s.close();
		}
	}

	@Override
	public void deleteEditor(Editor ed) {

		Session s = HibernateUtil.getSession();
		Transaction tx = null;

		try {

			tx = s.beginTransaction();
			s.delete(ed);
			tx.commit();

		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();

		} finally {

			s.close();
		}
	}
}
