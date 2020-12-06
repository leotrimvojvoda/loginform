<%--
  Created by IntelliJ IDEA.
  User: leotrimvojvoda
  Date: 12/6/20
  Time: 10:50 am
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
    <link rel="stylesheet" type="text/css" href="../resources/css/main.css" />
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


    <h1>- Update -</h1>

    <ul>

        <form:form action ="update" modelAttribute="newUser">

            <form:input path="id" cssClass="cred" placeholder = "ID" readonly="true"/>

            <form:input path="firstName" class = "cred" placeholder="First Name"/>
            <form:errors path="firstName" cssClass="error"/><br><br>

            <form:input path="lastName" class = "cred" placeholder="Last Name"/>
            <form:errors path="lastName" cssClass="error"/><br><br>

            <form:input path="email" class = "cred" placeholder="E-mail"/>
            <form:errors path = "email" cssClass="error"/><br><br>

           <!-- <form:password path="userPassword" class = "cred" placeholder="New password"/>
            <form:errors path="userPassword" cssClass="error"/><br><br> -->

            <form:input path="age" type = "number" class = "cred" placeholder="Age"/>
            <form:errors path="age" cssClass="error"/><br><br>


            <!--Choose your country -->
            Choose Your Country
            <form:select  id="countries" path="country">
                <option value="Misr">Misr</option>
                <option value="Turkey">Turkey</option>
                <option value="Ash-Sham">Ash-Sham</option>
                <option value="Rome">Rome</option>
                <option value="North">North</option>
            </form:select><br><br>


            Languages:
            English <form:checkbox path="languages"  cssClass="language" value="English "/>
            German <form:checkbox path="languages" cssClass="language" value="German "/>
            Albanian <form:checkbox path="languages" cssClass="language" value="Albanian "/><br>
            <form:errors path="languages" cssClass="error"/><br><br>


            Gender:
            <form:radiobutton path="gender" value="M"/> Male
            <form:radiobutton path="gender" value="F"/> Female
            <form:errors path="gender" cssClass="error"/>


            <br><br>

            - <input type ="submit" class = "submitButton" value = "Save Changes"> -<br><br>
            <a href = ../index.jsp>cancel</a>

        </form:form>

    </ul>


</div>

</body>
</html>