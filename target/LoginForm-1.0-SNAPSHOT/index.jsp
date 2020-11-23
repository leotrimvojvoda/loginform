<%--
  Created by IntelliJ IDEA.
  User: leotrimvojvoda
  Date: 11/8/20
  Time: 7:59 am
  To change this template use File | Settings | File Templates.
--%>
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

    <h1>Login</h1>

    <ul>

        <form action ="${pageContext.request.contextPath}login" method = "get">

           <input type = "text" name = "email" class = "cred" placeholder="Email"required><br><br>
            <input type = "password" name = "psswd" class = "cred" placeholder="Password"required><br><br>

            <input type ="submit" class = "submitButton" id = "button">

        </form>

    </ul>

    <form action = "${pageContext.request.contextPath}createAccount" method="GET">

        <input type="submit" class = "hyperlink" id = "createAccount" name = "form" value ="Create Account"><br>

    </form>
<br>

    <form action = "${pageContext.request.contextPath}adminPage" method="GET">

        <input type="submit" class = "hyperlink" id = "adminPage" name = "form" value ="Admin Page"><br>

    </form>

</div>

</body>

</html>

