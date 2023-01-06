package com.example.lab1.Servlets.book;

import com.example.lab1.Bean.BookBean;
import com.example.lab1.Bean.LibraryUserBean;
import com.example.lab1.Entity.Book;
import com.example.lab1.Entity.LibraryUser;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookEditServlet", value = "/EditBook")
public class BookEditServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;

    @EJB
    private LibraryUserBean libraryUserBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        List<LibraryUser> users = libraryUserBean.getAll();

        request.setAttribute("users", users);

        request.setAttribute("namePage", "Редактирование");
        Long bookId = Long.valueOf(request.getParameter("bookId"));
        Book book = bookBean.get(bookId);

        request.setAttribute("book", book);

        request.getRequestDispatcher("/bookEdit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        Long yearOfPublication = Long.parseLong(request.getParameter("yearOfPublication"));
        Long libraryUserId;

        if (request.getParameter("users").equals("null") || request.getParameter("users") == null)
            libraryUserId = null;
        else
            libraryUserId = Long.parseLong(request.getParameter("users"));

        Long bookId = Long.valueOf(request.getParameter("bookId"));
        Book book = bookBean.get(bookId);
        book.setAuthor(author);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setYearOfPublication(yearOfPublication);

        if(libraryUserId != null) {
            LibraryUser libraryUser = libraryUserBean.get(libraryUserId);
            libraryUser.addBook(book);
            libraryUserBean.update(libraryUser);
        } else {
            LibraryUser OldLibraryUser = book.getLibraryUser();
            if(OldLibraryUser != null){
                OldLibraryUser.removeBook(book);
                libraryUserBean.update(OldLibraryUser);
            }
        }
        bookBean.update(book);

        //ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
