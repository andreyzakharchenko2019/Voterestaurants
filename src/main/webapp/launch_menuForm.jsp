<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dish</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Create dish' : 'Edit dish'}</h2>
    <jsp:useBean id="launchMenu" class="com.andreyzakharchenko.voterestaurants.model.LaunchMenu" scope="request"/>
    <form method="post" action="launch_menu">
        <input type="hidden" name="id" value="${launchMenu.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${launchMenu.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="number" step="0.1" value="${launchMenu.price}" size=40 name="price" required></dd>
        </dl>
        <dl>
            <dt>DateTime:</dt>
            <dd><input type="date" value="${launchMenu.date}" name="date" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
