package org.sbweb;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>User List</h2>");
        out.println("<table border='1'><tr><th>Name</th><th>Agree</th><th>Hobbies</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/formdb", "root", ""
            );

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("name") + "</td><td>" +
                        rs.getString("agree") + "</td><td>" +
                        rs.getString("hobby") + "</td></tr>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</table>");
        out.println("<br><a href='index.html'>Go Back</a>");
    }
}
