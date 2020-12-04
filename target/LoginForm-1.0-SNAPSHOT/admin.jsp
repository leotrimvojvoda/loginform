<%--
  Created by IntelliJ IDEA.
  User: leotrimvojvoda
  Date: 11/13/20
  Time: 5:17 pm
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Admin Page</title>
    <meta name="description" content="Interactive ADMIN PAGE">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css" />
    <link href="https://fonts.googleapis.com/css2?family=Nova+Round&display=swap" rel="stylesheet">
</head>

<html>
<head>
    <title>Title</title>
</head>
<body style="width: 99%; padding: 0px" >
<div class = "container" id = "container">
   <h1>- ADMIN MODE -</h1>

</div>

<div class = "container" id = "container2">

    <table>
        <tr class = "header">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
           <!-- <th>Password</th> -->
            <th>Country</th>
            <th>Age</th>
            <th>Languages</th>
            <!--<th>Verified</th>-->
            <th>Update</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="users" items="${users}">

            <tr>
                <td>${users.id}</td>
                <td>${users.firstName}</td>
                <td>${users.lastName}</td>
                <td>${users.email}</td>
              <!--  <td>${users.userPassword}</td> -->
                <td>${users.country}</td>
                <td>${users.age}</td>
                <td>${users.languages}</td>
                <td><input type ="submit" class="adminUpdate"value = "Update"></td>
                <td><input type ="submit" class="adminDelete"value = "Delete"></td>
            </tr>
        </c:forEach>

    </table>
        <br><br>
    <a href = index.jsp>cancel</a>
</div>

</body>
</html>