<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Рестораны</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Restaurants</h2>

<a href="meals?action=create">Add Meal</a>

<br>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${restaurants}" var="restaurant">
        <jsp:useBean id="restaurant" type="com.andreyzakharchenko.voterestaurants.model.Restaurant"/>
        <tr>
            <td>${restaurant.name}</td>
            <td><a href="restaurants?action=update&id=${restaurant.id}">Update</a></td>
            <td><a href="restaurants?action=delete&id=${restaurant.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>