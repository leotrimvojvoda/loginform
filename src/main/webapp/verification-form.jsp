<%--
  Created by IntelliJ IDEA.
  User: leotrimvojvoda
  Date: 11/23/20
  Time: 4:55 pm
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
    <link rel="stylesheet" type="text/css" href="resources/css/main.css?version=52" />
    <link href="https://fonts.googleapis.com/css2?family=Nova+Round&display=swap" rel="stylesheet">
</head>

<body>

<div class = "container">

    A 6 digit code was sent to: ${verifyUser.email}
    <br><br>
    <ul>

        <form:form action = "${pageContext.request.contextPath}checkVerification" modelAttribute="verifyUser">

            <input type="text" name = "verificationCode" class="cred" id ="verificationCode" placeholder ="Verification Code"><br><br>

            <input type="submit" class = "submitButton" id = "editProfileButton" name = "form" value ="Verify Email">

        </form:form>

    </ul>

</div>

</body>

</html>
