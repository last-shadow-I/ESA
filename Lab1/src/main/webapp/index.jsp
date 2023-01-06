<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
</head>
<body>
<h3>Книги:</h3><a href="AddBook">Добавить книгу</a>
<ol>
    <c:forEach items="${books}" var = "book">
        <li>
                ${book.toString()}
            <a href="EditBook?bookId=${book.getBookId()}">Редактировать</a> | <a href="RemoveBook?bookId=${book.getBookId()}">Удалить</a>
        </li>
    </c:forEach>
</ol>

<h3>Пользователи:</h3><a href="AddUser">Добавить пользователя</a>
<ol>
    <c:forEach items="${users}" var = "user">
        <li>
                ${user.toString()}
            <a href="EditUser?libraryUserId=${user.getLibraryUserId()}">Редактировать</a> | <a href="RemoveUser?libraryUserId=${user.getLibraryUserId()}">Удалить</a>
                    <br>
                    <c:forEach items="${user.getBooks()}" var = "book">
                        <pre>    ${book.getTitle()}</pre>
                    </c:forEach>
        </li>
    </c:forEach>
</ol>
</body>
</html>