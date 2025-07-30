package org.sbweb;



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String agree = request.getParameter("agree");
        String[] hobbies = request.getParameterValues("hobby");

        String hobbyStr = "";
        if (hobbies != null) {
            hobbyStr = String.join(", ", hobbies);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/formdb", "root", ""
            );

            PreparedStatement pst = con.prepareStatement("INSERT INTO users(name, agree, hobby) VALUES (?, ?, ?)");
            pst.setString(1, name);
            pst.setString(2, agree);
            pst.setString(3, hobbyStr);

            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.html");
    }
}
