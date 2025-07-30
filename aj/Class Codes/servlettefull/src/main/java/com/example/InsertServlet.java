package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String agree = request.getParameter("agree");
        String[] hobbies = request.getParameterValues("hobby");
        String hobbyStr = (hobbies != null) ? String.join(",", hobbies) : "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (name, choice, hobby) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, agree);
            ps.setString(3, hobbyStr);
            ps.executeUpdate();
            response.getWriter().println("Inserted. <a href='display'>View All</a>");
            response.sendRedirect("display");

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
