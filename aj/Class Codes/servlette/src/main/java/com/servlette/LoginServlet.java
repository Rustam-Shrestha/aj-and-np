package com.servlette;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded login validation
        if ("admin".equals(username) && "admin123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("form.html"); // protected page
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<p>Invalid credentials. <a href='login.html'>Try again</a></p>");
        }
    }
}
