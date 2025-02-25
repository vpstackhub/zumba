package com.servlet;

import java.io.IOException;
import com.dao.StudentDAO;
import com.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Enroll extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Enroll() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Student student = new Student(0, name, email); 

        StudentDAO studentDAO = new StudentDAO();
        boolean success = studentDAO.addStudent(student);

        if (success) {
            response.getWriter().println("Enrollment successful!");
        } else {
            response.getWriter().println("Enrollment failed. Please try again.");
        }
    }
}
