<%--
  Created by IntelliJ IDEA.
  User: leotrimvojvoda
  Date: 11/8/20
  Time: 12:32 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta name="description" content="Interactive Login Form.">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css" />
    <link href="https://fonts.googleapis.com/css2?family=Nova+Round&display=swap" rel="stylesheet">
</head>

<body>

<div class = "container">

    <ul>

        <li>ID: ${dbUser.id}</li>
        <li>First Name: ${dbUser.firstName}</li>
        <li>Last Name: ${dbUser.lastName}</li>
        <li>Email: ${dbUser.email}
        <li>Password: ${dbUser.userPassword}</li>
        <li>Country: ${dbUser.country}</li>
        <li>Age: ${dbUser.age}</li>
        <li>Gender: ${dbUser.gender}</li>
        <li>Lanuages: ${dbUser.languages}</li>

    </ul>

    <br><br>
    <form:form action = "${pageContext.request.contextPath}editPage" modelAttribute="dbUser">

        <input type="submit" class = "submitButton" id = "editProfileButton" name = "form" value ="Edit Profile">

    </form:form>

    <br><br>
    <form:form action = "${pageContext.request.contextPath}enterCode" modelAttribute="dbUser">

        <input type="submit" class = "submitButton" id = "editProfileButton" name = "form" value ="Verify Email">

    </form:form>



    <a href = index.jsp>cancel</a>
</div>

</body>

</html>

