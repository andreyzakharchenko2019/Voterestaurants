<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Меню</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Menu</h2>

<a href="launch_menu?action=create">Add dish</a>

<br>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Блюдо</th>
        <th>Цена</th>
        <th>Ресторан</th>
        <th>Дата</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${launch_menus}" var="launch_menu">
        <jsp:useBean id="launch_menu" type="com.andreyzakharchenko.voterestaurants.model.LaunchMenu"/>
        <tr>
            <td>${launch_menu.name}</td>
            <td>${launch_menu.price}</td>
            <td>${launch_menu.restaurant_id}</td>
            <td>${launch_menu.date}</td>
            <td><a href="launch_menu?action=update&id=${launch_menu.id}">Update</a></td>
            <td><a href="launch_menu?action=delete&id=${launch_menu.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>