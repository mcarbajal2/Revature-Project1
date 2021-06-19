package dev.carbajal.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();

		// Sessions

//		HttpSession session = request.getSession();
//		System.out.println(session.getId());
//
//		session.setAttribute("loggedInUser", "{'firstName': Mina, 'lastName': Carbajal, 'age': 24}");
//
//		System.out.println(session.getAttribute("loggedInUser"));
//
//		session.setMaxInactiveInterval(0);
//		session.invalidate();


		switch(uri) {

		case "/StoryPitchMS/author":
			response.sendRedirect("/StoryPitchMS/AuthorServlet");
			break;

		case "/ServletExample/editor":
			response.sendRedirect("/StoryPitchMS/EditorServlet");
			break;

		default:
			response.sendRedirect("/StoryPitchMS/LoginServlet");
			break;
		}	
	}
}
