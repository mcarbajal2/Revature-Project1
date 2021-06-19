package dev.carbajal.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dev.carbajal.models.Author;

@SuppressWarnings("serial")
public class AuthorServlet extends HttpServlet {

//	public Gson gson = new Gson();
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		Author a = new Author();
//
//		response.getWriter().append(gson.toJson(a, Author.class));
//
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		Author a = gson.fromJson(request.getReader(), Author.class);
//
//		System.out.println(a);
//
//		response.getWriter().append(gson.toJson(a));
//
//	}
	
}
