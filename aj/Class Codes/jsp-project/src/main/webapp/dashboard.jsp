<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<h2>Welcome, <%= session.getAttribute("user") %></h2>
<ul>
    <li><a href="insert.jsp">Insert New</a></li>
    <li><a href="display.jsp">Display All</a></li>
</ul>
