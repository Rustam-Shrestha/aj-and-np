package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourdb", "youruser", "yourpass");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>User List</h2><table border='1'>");
            out.println("<tr><th>Name</th><th>Choice</th><th>Hobby</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("name") + "</td><td>" +
                        rs.getString("choice") + "</td><td>" + rs.getString("hobby") + "</td></tr>");
            }
            out.println("</table><a href='index.html'>Back</a></body></html>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}