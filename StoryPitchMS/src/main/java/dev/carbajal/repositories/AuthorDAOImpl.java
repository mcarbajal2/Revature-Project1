package dev.carbajal.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.carbajal.models.Author;
import dev.carbajal.utils.HibernateUtil;

public class AuthorDAOImpl implements AuthorDAO {

	@Override
	public Author addAuthor(Author a) {
		
		Session s = HibernateUtil.getSession();
		
		try {
			
			s.beginTransaction();
			s.save(a);
			s.getTransaction().commit();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			s.getTransaction().rollback();
			
		} finally {
			
			s.close();
		}
		
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAllAuthors() {
		
		Session s = HibernateUtil.getSession();
		List<Author> authors = null;
		
		try {
			
			authors = s.createQuery("from authors").list();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return authors;
	}

	@Override
	public Author getAuthorByName(String fName, String lName) {
		
		Session s = HibernateUtil.getSession();
		Author a = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Author> cr = cb.createQuery(Author.class);
			Root<Author> root = cr.from(Author.class);
			
			Predicate p1 = cb.equal(root.get("f_name"), fName);
			Predicate p2 = cb.equal(root.get("l_name"), lName);
			
			cr.select(root).where(cb.and(p1, p2));

			a = s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return a;
	}

	@Override
	public Author getAuthorByLogin(String username, String password) {
		
		Session s = HibernateUtil.getSession();
		Author a = null;
		
		try {
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Author> cr = cb.createQuery(Author.class);
			Root<Author> root = cr.from(Author.class);
			
			Predicate p1 = cb.equal(root.get("username"), username);
			Predicate p2 = cb.equal(root.get("password"), password);
			
			cr.select(root).where(cb.and(p1, p2));

			a = s.createQuery(cr).getSingleResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			
			s.close();
		}
		
		return a;
	}

//	@Override
//	public Author getAuthorPoints(Author id) {
//		
//		Session s = HibernateUtil.getSession();
//		Author a = null;
//		
//		try {
//			
//			CriteriaBuilder cb = s.getCriteriaBuilder();
//			CriteriaQuery<Author> cr = cb.createQuery(Author.class);
//			Root<Author> root = cr.from(Author.class);
//			
//			cr.select(root).where(cb.equal(root.get("id"), id));
//			
//			p = (Author) s.createQuery(cr);
//			
//		} catch (HibernateException e) {
//			
//			System.out.println(e.getStackTrace());
//			
//		} finally {
//			
//			s.close();
//		}
//		
//		return p;
//	}

//	@Override
//	public boolean checkIfAuthorExists(int authorId) {
//		
//		return false;
//	}

	@Override
	public void updateAuthor(Author a) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			
			tx = s.beginTransaction();
			s.save(a);
			tx.commit();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			tx.rollback();
			
		} finally {
			
			s.close();
		}
	}

	@Override
	public void deleteAuthor(Author a) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			
			tx = s.beginTransaction();
			s.delete(a);
			tx.commit();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			tx.rollback();
			
		} finally {
			
			s.close();
		}
	}
}
