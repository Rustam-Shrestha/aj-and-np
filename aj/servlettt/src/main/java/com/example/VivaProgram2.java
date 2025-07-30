package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class VivaProgram2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String db_url = "jdbc:mysql://localhost:3306/jsp_servlet";
        String db_user = "root";
        String db_password = "";

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email.isEmpty() || password.isEmpty()) {
            out.println("Please ensure no field is empty.");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

            try (Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
                 PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    out.println("Login Successful.");
                } else {
                    out.println("Login Unsuccessful! Invalid credentials.");
                }
            }
        } catch (ClassNotFoundException e) {
            out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
        }
    }
}