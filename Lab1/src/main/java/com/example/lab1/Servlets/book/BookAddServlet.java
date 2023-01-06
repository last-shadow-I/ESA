package com.example.lab1.Servlets.book;

import com.example.lab1.Bean.BookBean;
import com.example.lab1.Bean.LibraryUserBean;
import com.example.lab1.Entity.Book;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookAddServlet", value = "/AddBook")
public class BookAddServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;

    @EJB
    private LibraryUserBean libraryUserBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("namePage", "Добавление");

        request.getRequestDispatcher("/bookAdd.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        Long yearOfPublication = Long.parseLong(request.getParameter("yearOfPublication"));
        Long libraryUserId = null;

        bookBean.add(new Book(author, title,publisher,yearOfPublication));
        //ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
