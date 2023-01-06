package com.example.lab1.Servlets.book;

import com.example.lab1.Bean.BookBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookRemoveServlet", value = "/RemoveBook")
public class BookRemoveServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        if(request.getParameter("bookId") != null){
            request.setAttribute("namePage", "Удаление");
            Long bookId = Long.valueOf(request.getParameter("bookId"));
            bookBean.delete(bookId);
        } else
            request.setAttribute("namePage", "Error 404");
        //ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
