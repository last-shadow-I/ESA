package com.example.lab1.Servlets.user;

import com.example.lab1.Bean.LibraryUserBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LibraryUserRemoveServlet", value = "/RemoveUser")
public class LibraryUserRemoveServlet extends HttpServlet {

    @EJB
    private LibraryUserBean libraryUserBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        if(request.getParameter("libraryUserId") != null){
            request.setAttribute("namePage", "Удаление");
            Long libraryUserId = Long.valueOf(request.getParameter("libraryUserId"));
            libraryUserBean.delete(libraryUserId);
        }
        else
            request.setAttribute("namePage", "Error 404");
        response.sendRedirect(request.getContextPath() + "/index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
