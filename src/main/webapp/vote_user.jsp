<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мои обеды</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Мои обеды</h2>

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
    <c:forEach items="${voteUser}" var="voteUser">
        <jsp:useBean id="voteUser" type="com.andreyzakharchenko.voterestaurants.model.VoteUser"/>
        <tr>
            <td>${voteUser.launch_id}</td>
            <td>${voteUser.date_vote}</td>
            <%--<td><a href="launch_menu?action=update&id=${voteUser.id}">Update</a></td>
            <td><a href="launch_menu?action=delete&id=${voteUser.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>