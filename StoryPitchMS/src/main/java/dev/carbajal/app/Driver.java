package dev.carbajal.app;

import dev.carbajal.models.Author;
import dev.carbajal.repositories.AuthorDAO;
import dev.carbajal.repositories.AuthorDAOImpl;
import dev.carbajal.services.AuthorServices;
import dev.carbajal.services.AuthorServicesImpl;

public class Driver {
	
	private static AuthorDAO aDAO = new AuthorDAOImpl();
	private static AuthorServices aServ = new AuthorServicesImpl();
	
	public static void main(String[] args) {
		
		Author test = new Author();
		test.setUsername("a1");
		test.setPassword("a1");
		test.setlName("a");
		test.setfName("a");
		
		aServ.addAuthor(test);
		
	}

}
