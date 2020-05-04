package com.folies.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.DriverManager;

@WebServlet(name = "TestDBServlet")
public class TestDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        var user = "springstudent";
        var password = "springstudent";

        var jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";
        var driver = "com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);
            Class.forName(driver);
            var connection = DriverManager.getConnection(jdbcUrl, user, password);
            out.println("SUCCESS!!!");
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ServletException(exception);
        }
    }
}
