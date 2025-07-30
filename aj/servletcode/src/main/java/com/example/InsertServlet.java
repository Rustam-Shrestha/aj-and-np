package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String choice = request.getParameter("choice");
        String[] hobbies = request.getParameterValues("hobby");

        String hobbiesCombined = "";
        if (hobbies != null) {
            hobbiesCombined = String.join(",", hobbies);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourdb", "youruser", "yourpass");
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO users(name, choice, hobby) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, choice);
            ps.setString(3, hobbiesCombined);
            ps.executeUpdate();

            PrintWriter out = response.getWriter();
            out.println("Data inserted successfully. <a href='index.html'>Go Back</a>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}