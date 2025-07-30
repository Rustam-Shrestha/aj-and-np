<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head><title>Dashboard</title></head>
<body>
<h2>User Dashboard</h2>

<!-- Insert Form -->
<form action="insert.jsp" method="post">
    Name: <input type="text" name="name" required><br>
    Hobbies: <input type="text" name="hobby"><br>
    Agree (yes/no): <input type="text" name="choice"><br>
    <input type="submit" value="Insert">
</form>

<hr>
<a href="display.jsp">View All Entries</a> |
<a href="update.jsp">Update Entry</a>
</body>
</html>
