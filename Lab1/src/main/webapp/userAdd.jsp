<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>${namePage}</title>
</head>
<body>
<form action="AddUser" method="post">
  <label for="fullName">Введите ФИО:
    <input type="text" id="fullName" name="fullName" required = "required"/>
  </label>  <br />
  <label for="age">Введите возраст:
    <input type="number" id="age" name="age" min="14" max="120" required = "required"/>
  </label>  <br />
  <label for="address">Введите адрес:
    <input type="text" id="address" name="address" required = "required"/>
  </label>  <br />
  <label for="phoneNumber">Введите телефон:
    <input type="tel" id="phoneNumber" pattern="[8]{1}-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}" name="phoneNumber" required = "required"/>
  </label> <small>Формат номера: 8-***-***-**-**</small> <br />

  <input type="submit" value="Сохранить" />
</form>
</body>
</html>
