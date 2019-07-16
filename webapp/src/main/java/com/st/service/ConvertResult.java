package com.st.service;

import java.sql.SQLException;
import java.sql.ResultSet;

import com.st.models.Author;

public class ConvertResult {
	
	
	public static Author convertToAuthor(ResultSet result) {
		try {
		    int authorId = result.getInt("authorId");
		    String authorName = result.getString("authorName");
		    Author newAuthor = new Author(authorId, authorName);
		    return newAuthor;
		}
		catch (SQLException e) {
			return null;
		}
	}
}
