package com.st.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.st.models.Author;
import com.st.service.ConvertResult;

public class AuthorDAO{
	
	private static AuthorDAO instance;
	
	private AuthorDAO() {}
	
	public static AuthorDAO getInstance() {
		if (instance == null) {
			instance = new AuthorDAO();
		}
		return instance;
	}
	
	public void insertAuthor(Author author) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC", "root", password);
            String sql = "INSERT INTO library.tbl_author(authorId, authorName) VALUES (?,?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, author.getAuthorId());
            statement.setString(2, author.getAuthorName());
            statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteAuthor(int authorId) {
		Connection conn = null;
		PreparedStatement statement = null;;
		try {
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC", "root", password);
			String sql = "DELETE FROM library.tbl_author WHERE authorId=?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, authorId);
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateAuthor(Author newAuthor) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC", "root", password);
			String sql = "UPDATE library.tbl_author SET authorName=? WHERE authorId=?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, newAuthor.getAuthorName());
			statement.setInt(2, newAuthor.getAuthorId());
			statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Author selectAuthor(int authorId) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC", "root", password);
			String sql = "SELECT * FROM library.tbl_author WHERE authorId=?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, authorId);
			result = statement.executeQuery();
			Author author = ConvertResult.convertToAuthor(result);
			return author;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String password = "Nblastingrotisseriechicken";
}