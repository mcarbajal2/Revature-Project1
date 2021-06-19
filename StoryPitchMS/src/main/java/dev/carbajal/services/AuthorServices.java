package dev.carbajal.services;

import java.util.List;

import dev.carbajal.models.Author;

public interface AuthorServices {
	
	public Author addAuthor(Author a);
	
	public List<Author> getAllAuthors();
	
	public Author getAuthorByName(String fName, String lName);
	
	public Author getAuthorByLogin(String username, String password);
	
	public void updateAuthor(Author a);
	
	public void deleteAuthor(Author a);

}
