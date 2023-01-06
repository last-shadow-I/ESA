package com.example.lab1.Servlets.user;

import com.example.lab1.Bean.BookBean;
import com.example.lab1.Bean.LibraryUserBean;
import com.example.lab1.Entity.LibraryUser;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LibraryUserEditServlet", value = "/EditUser")
public class LibraryUserEditServlet extends HttpServlet {

    @EJB
    private BookBean bookBean;
    @EJB
    private LibraryUserBean libraryUserBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("namePage", "Редактирование");
        Long libraryUserId = Long.valueOf(request.getParameter("libraryUserId"));
        LibraryUser libraryUser = libraryUserBean.get(libraryUserId);

        request.setAttribute("user", libraryUser);

        request.getRequestDispatcher("/userEdit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        String fullName = request.getParameter("fullName");
        Long age = Long.valueOf(request.getParameter("age"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");

        Long libraryUserId = Long.valueOf(request.getParameter("libraryUserId"));

        LibraryUser libraryUser = libraryUserBean.get(libraryUserId);
        libraryUser.setFullName(fullName);
        libraryUser.setAge(age);
        libraryUser.setAddress(address);
        libraryUser.setPhoneNumber(phoneNumber);

        libraryUserBean.update(libraryUser);

        //ServletContext servletContext = getServletContext();
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
