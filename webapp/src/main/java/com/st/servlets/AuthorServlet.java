package com.st.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.st.models.Author;
import com.st.service.AuthorService;

@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AuthorServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	                                                                                       IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String authorName = request.getParameter("authorName");
		String authorId = request.getParameter("authorId");
		int idAsInt = Integer.parseInt(authorId);
		String insert = request.getParameter("Insert");
		String retrieve = request.getParameter("Retrieve");
		String update = request.getParameter("Update");
		String delete = request.getParameter("Delete");
		Author newAuthor = null;
	    if (authorName != null && authorId != null) {
	    	newAuthor = new Author(idAsInt, authorName);
	    }
		int validation;
		AuthorService instance = AuthorService.getInstance();
		if (insert != null) {
			if (newAuthor == null) {
				out.print("Invalid creation, authorId and authorName must be non null");
			}
			validation = instance.createAuthor(newAuthor);
			if (validation == AuthorService.AUTHOR_ALREADY_EXISTS) {
				out.print("Invalid creation author with id " + authorId + " already exists");
			}
			else {
				out.print("Successful creation of author with id " + authorId);
			}
		}
		if (retrieve != null) {
			if (authorId == null) {
				out.print("Invalid retrieval, authorId must be non null");
			}
			newAuthor = instance.retrieveAuthor(idAsInt);
			if (newAuthor == null) {
				out.print("Invalid retrieval, Author with id " + authorId + " was not found");
			}
			else {
				out.print("You have retrieved author with authorName: " + authorName + " authorId: " +
			              authorId);
			}
		}
		if (update != null) {
			if (newAuthor == null) {
				out.print("Invalid update, authorId and authorName must be non null");
			}
			validation = instance.updateAuthor(newAuthor);
			if (validation == AuthorService.AUTHOR_DOES_NOT_EXIST) {
				out.print("Invalid update, author with id " + authorId + " was not found");
			}
			else {
				out.print("Successful update of author with id " + authorId );
			}
		}
		if (delete != null) {
			if (authorId == null) {
				out.print("Invalid delete, authorId must be non null");
			}
			validation = instance.deleteAuthor(idAsInt);
			if (validation == AuthorService.AUTHOR_DOES_NOT_EXIST) {
				out.print("Invalid deletion, author with id " + authorId + " was not found");
			}
			else {
				out.print("Successful deletion of author with id " + authorId);
			}
		}
		out.close();
	}
    
}
