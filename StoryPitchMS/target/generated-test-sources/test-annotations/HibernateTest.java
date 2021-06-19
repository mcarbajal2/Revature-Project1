import static org.junit.Assert.*;

import org.junit.Test;

import dev.carbajal.models.Author;
import dev.carbajal.repositories.AuthorDAO;
import dev.carbajal.repositories.AuthorDAOImpl;

public class HibernateTest {
	
	private AuthorDAO adi = new AuthorDAOImpl();

	@Test
	public void testgetAuthorByLogin() {

		Author a = adi.getAuthorByLogin("author1", "author1");
		System.out.println(a);
		
	}

}
