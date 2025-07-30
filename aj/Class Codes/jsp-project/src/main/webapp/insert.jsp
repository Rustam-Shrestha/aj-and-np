<%@ include file="db.jsp" %>
<%
    String name = request.getParameter("name");
    String hobby = request.getParameter("hobby");
    String choice = request.getParameter("choice");

    if (conn != null) {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, hobby, choice) VALUES (?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, hobby);
        ps.setString(3, choice);
        int rows = ps.executeUpdate();
        out.println(rows > 0 ? "Inserted successfully!" : "Insert failed.");
        ps.close();
        conn.close();
    }
%>
<a href="index.jsp">Go Back</a>
