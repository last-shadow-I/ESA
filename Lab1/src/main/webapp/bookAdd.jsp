<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${namePage}</title>
</head>
<body>
<form action="AddBook" method="post">
    <label for="title">Введите название книги:
        <input type="text" id="title" name="title" required = "required"/>
    </label>  <br />
    <label for="author">Введите автора:
        <input type="text" id="author" name="author" required = "required"/>
    </label>  <br />
    <label for="publisher">Введите издательство:
        <input type="text" id="publisher" name="publisher" required = "required"/>
    </label>  <br />
    <label for="yearOfPublication">Введите год выпуска:
        <input type="number" id="yearOfPublication"  name="yearOfPublication" min="0" max="2023" required = "required"/>
    </label>  <br />
<%--    <label for="libraryUserId">Выберите пользователя:--%>
<%--        <select  id="libraryUserId" name="libraryUserId">--%>
<%--            <option value="null">Не указан</option>--%>
<%--            <c:forEach var="item" items="${owners}">--%>
<%--                <option value="${item.getId()}">${item.getInfo()}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--    </label>  <br />--%>
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>
