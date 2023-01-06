<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${namePage}</title>
</head>
<body>
<form action="EditBook" method="post">
    <label for="title">Введите название книги:
        <input type="text" id="title" value="${book.title}" name="title" required = "required"/>
    </label>  <br />
    <label for="author">Введите автора:
        <input type="text" id="author" value="${book.author}" name="author" required = "required"/>
    </label>  <br />
    <label for="publisher">Введите издательство:
        <input type="text" id="publisher" value="${book.publisher}" name="publisher" required = "required"/>
    </label>  <br />
    <label for="yearOfPublication">Введите год выпуска:
        <input type="number" id="yearOfPublication" value="${book.yearOfPublication}" name="yearOfPublication" min="0" max="2023" required = "required"/>
    </label>  <br />
        <label for="users">Выберите пользователя:
            <select  id="users" name="users">
                <option value="null">Библиотека</option>
                <c:forEach var="user" items="${users}">
                    <option value="${user.getLibraryUserId()}">${user.getFullName()}</option>
                </c:forEach>
            </select>
        </label>  <br />
    <input type="hidden" id="bookId" value="${book.bookId}" name="bookId" />
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>
