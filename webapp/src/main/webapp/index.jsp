<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author Servlet</title>
</head>
<body>
<form method="post" action="AuthorServlet">
	<font face="verdana" size="2px">Author Name:</font>
	<input type="text" name="authorName">
	<br>
	<font face="verdana" size="2px">Author Id:</font>
	<input type="text" name="authorId">
		<br>
	<input type="submit" value="Create" name="Create">
	<br>
	<input type="submit" value="Retrieve" name="Retrieve">
	<br>
	<input type="submit" value="Update" name="Update">
	<br>
	<input type="submit" value="Delete" name="Delete">
</form>
</body>
</html>