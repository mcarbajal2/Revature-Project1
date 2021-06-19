package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Author;
import dev.carbajal.repositories.AuthorDAO;
import dev.carbajal.repositories.AuthorDAOImpl;

public class AuthorServicesImpl implements AuthorServices {
	
	private AuthorDAO ad = new AuthorDAOImpl();

	@Override
	public Author addAuthor(Author a) {

		return ad.addAuthor(a);
	}

	@Override
	public List<Author> getAllAuthors() {

		return ad.getAllAuthors();
	}

	@Override
	public Author getAuthorByName(String fName, String lName) {

		return ad.getAuthorByName(fName, lName);
	}

	@Override
	public Author getAuthorByLogin(String username, String password) {

		return ad.getAuthorByLogin(username, password);
	}

	@Override
	public void updateAuthor(Author a) {
		
		ad.updateAuthor(a);
	}

	@Override
	public void deleteAuthor(Author a) {
		
		ad.deleteAuthor(a);
	}
}
