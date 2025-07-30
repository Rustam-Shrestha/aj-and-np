<%@ include file="db.jsp" %>
<%
    if (conn != null) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Hobby</th><th>Choice</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                        rs.getString("name") + "</td><td>" +
                        rs.getString("hobby") + "</td><td>" +
                        rs.getString("choice") + "</td></tr>");
        }
        out.println("</table>");
        rs.close();
        stmt.close();
        conn.close();
    }
%>
<a href="index.jsp">Go Back</a>
