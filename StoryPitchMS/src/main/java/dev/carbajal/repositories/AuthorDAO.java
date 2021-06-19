package dev.carbajal.repositories;

import java.util.List;

import dev.carbajal.models.Author;

public interface AuthorDAO {
	
	// CRUD //
	
	// Create
	
	public Author addAuthor(Author a);
	
	// Read
	
	public List<Author> getAllAuthors();
	
	public Author getAuthorByName(String fName, String lName);
	
	public Author getAuthorByLogin(String username, String password);
	
//	public int getAuthorPoints(int authorId);
	
//	public boolean checkIfAuthorExists(int authorId);
	
	// Update
	
	public void updateAuthor(Author a);
	
	// Delete
	
	public void deleteAuthor(Author a);

}
