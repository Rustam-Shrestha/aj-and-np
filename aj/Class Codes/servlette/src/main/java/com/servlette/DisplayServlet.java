package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            out.println("<table border='1'><tr><th>Name</th><th>Agree</th><th>Hobbies</th></tr>");
            while(rs.next()) {
                out.println("<tr><td>" + rs.getString("name") + "</td><td>" +
                        rs.getString("choice") + "</td><td>" + rs.getString("hobby") + "</td></tr>");
            }
            out.println("</table>");
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
