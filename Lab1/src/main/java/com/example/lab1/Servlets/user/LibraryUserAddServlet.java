package com.example.lab1.Servlets.user;

import com.example.lab1.Bean.BookBean;
import com.example.lab1.Bean.LibraryUserBean;
import com.example.lab1.Entity.LibraryUser;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LibraryUserAddServlet", value = "/AddUser")
public class LibraryUserAddServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;
    @EJB
    private LibraryUserBean libraryUserBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("namePage", "Добавление");

        request.getRequestDispatcher("/userAdd.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String fullName = request.getParameter("fullName");
        Long age = Long.valueOf(request.getParameter("age"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        libraryUserBean.add(new LibraryUser(fullName,age,address,phoneNumber));

        response.sendRedirect(request.getContextPath() + "/index");
    }
}
