package com.st.service;

import com.st.daos.AuthorDAO;
import com.st.models.Author;

public class AuthorService {
    
	public static final int SUCCESS = 0;
	public static final int AUTHOR_ALREADY_EXISTS = 1;
	public static final int AUTHOR_DOES_NOT_EXIST = 2;
	
	private AuthorService() {}
	
	private static AuthorService instance;
	
	public static AuthorService getInstance() {
		if (instance == null) {
			instance = new AuthorService();
		}
		return instance;
	}
	
	public int createAuthor(Author newAuthor) {
		if (authorExists(newAuthor.getAuthorId())) {
			return AUTHOR_ALREADY_EXISTS;
		}
		AuthorDAO instance = AuthorDAO.getInstance();
		instance.insertAuthor(newAuthor);
		return SUCCESS;
	}
	
	public Author retrieveAuthor(int targetId) {
		if (!authorExists(targetId)) {
			return null;
		}
		AuthorDAO instance = AuthorDAO.getInstance();
		return instance.selectAuthor(targetId);
	}
	
	public int updateAuthor(Author newAuthor) {
		if (!authorExists(newAuthor.getAuthorId())) {
			return AUTHOR_DOES_NOT_EXIST;
		}
		AuthorDAO instance = AuthorDAO.getInstance();
		instance.updateAuthor(newAuthor);
		return SUCCESS;
	}
	
	public int deleteAuthor(int targetId) {
		if (!authorExists(targetId)) {
			return AUTHOR_DOES_NOT_EXIST;
		}
		AuthorDAO instance = AuthorDAO.getInstance();
		instance.deleteAuthor(targetId);
		return SUCCESS;
	}
	
	private boolean authorExists(int targetId) {
		AuthorDAO instance = AuthorDAO.getInstance();
		Author match = instance.selectAuthor(targetId);
		if (match == null) {
			return false;
		}
		return true;
	}
}
