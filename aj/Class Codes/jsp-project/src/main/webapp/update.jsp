<%@ include file="db.jsp" %>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String hobby = request.getParameter("hobby");
    String choice = request.getParameter("choice");

    if (id != null && conn != null) {
        PreparedStatement ps = conn.prepareStatement("UPDATE users SET name=?, hobby=?, choice=? WHERE id=?");
        ps.setString(1, name);
        ps.setString(2, hobby);
        ps.setString(3, choice);
        ps.setInt(4, Integer.parseInt(id));
        int rows = ps.executeUpdate();
        out.println(rows > 0 ? "Updated successfully!" : "Update failed.");
        ps.close();
        conn.close();
    } else {
%>
        <form method="post" action="update.jsp">
            ID to Update: <input type="text" name="id" required><br>
            New Name: <input type="text" name="name"><br>
            New Hobby: <input type="text" name="hobby"><br>
            New Choice: <input type="text" name="choice"><br>
            <input type="submit" value="Update">
        </form>
<%
    }
%>
<a href="index.jsp">Go Back</a>
