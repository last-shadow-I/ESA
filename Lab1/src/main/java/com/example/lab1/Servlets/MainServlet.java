package com.example.lab1.Servlets;

import com.example.lab1.Bean.BookBean;
import com.example.lab1.Bean.LibraryUserBean;
import com.example.lab1.Entity.Book;
import com.example.lab1.Entity.LibraryUser;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AnimalOwnerInformationServlet", value = "/index")
public class MainServlet extends HttpServlet {
    @EJB
    private LibraryUserBean libraryUserBean;
    @EJB
    private BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<LibraryUser> libraryUsers = libraryUserBean.getAll();

        List<Book> books = bookBean.getAll();

        request.setAttribute("users", libraryUsers);
        request.setAttribute("books", books);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
