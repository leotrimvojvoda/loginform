<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Register</title>
    <meta name="description" content="An interactive getting started guide for Brackets.">
    <link rel="stylesheet" type="text/css" href="resources/css/main.css" />
    <link href="https://fonts.googleapis.com/css2?family=Nova+Round&display=swap" rel="stylesheet">
</head>

<body>

<div class = "container">

    <h1>- Register -</h1>

    <ul>

        <form:form action ="signUp" modelAttribute="newUser">

            <!--
            <input type = "text" path = "firstName" class = "cred" placeholder="First Name"required><br><br>
            <input type = "text" name = "lastName" class = "cred" placeholder="Last Name"required><br><br>
            <input type = "text" name = "email" class = "cred" placeholder="E-mail"required><br><br>
            <input type = "password" name = "userPassword" class = "cred" placeholder="Password"required><br><br>
            <input type = "password" name = "password2" class = "cred" placeholder="Repeat Password"required><br><br>
            <input type = "number" name = "age" class = "cred" placeholder="Age" min = "10" max = "110"  required><br><br>
                -->


            <form:input path="firstName" class = "cred" placeholder="First Name"/>
            <form:errors path="firstName" cssClass="error"/><br><br>

            <form:input path="lastName" class = "cred" placeholder="Last Name"/>
            <form:errors path="lastName" cssClass="error"/><br><br>

            <form:input path="email" class = "cred" placeholder="E-mail"/>
            <form:errors path = "email" cssClass="error"/><br><br>

            <form:password path="userPassword" class = "cred" placeholder="Password"/>
            <form:errors path="userPassword" cssClass="error"/><br><br>

            <form:input path="age" type = "number" class = "cred" placeholder="Age"/>
            <form:errors path="age" cssClass="error"/><br><br>


            <!--Choose your country -->
            Choose Your Country
            <form:select  id="countries" path="country">
                <option value="Misr">Misr</option>
                <option value="Turkey">Turkey</option>
                <option value="Montenegro">Montenegro</option>
                <option value="Luxembourg">Luxembourg</option>
                <option value="Myanmar">Myanmar</option>
                <option value="Afghanistan">Afghanistan</option>
                <option value="Bahamas">Bahamas</option>
                <option value="Georgia">Georgia</option>
                <option value="Bangladesh">Bangladesh</option>
                <option value="Iceland">Iceland</option>
                <option value="Haiti">Haiti</option>
                <option value="North Pole">North Pole</option>
            </form:select><br><br>




            Languages:
            English <form:checkbox path="languages"  cssClass="language" value="English "/>
            German <form:checkbox path="languages" cssClass="language" value="German "/>
            Albanian <form:checkbox path="languages" cssClass="language" value="Albanian "/><br>
            <form:errors path="languages" cssClass="error"/><br><br>



            <!--Gender:
            <input type="radio" id="male" name="gender" value="M">
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="F">
            <label for="female">Female</label><br> -->

            Gender:
            <form:radiobutton path="gender" value="M"/> Male
            <form:radiobutton path="gender" value="F"/> Female
            <form:errors path="gender" cssClass="error"/>


            <br><br>

            - <input type ="submit" class = "submitButton" value = "Add User"> -<br><br>
            <a href = index.jsp>cancel</a>

        </form:form>

    </ul>

</div>

</body>

</html>