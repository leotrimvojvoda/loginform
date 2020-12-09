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

    <h1>- Edit Profile -</h1>

    <ul>

        <form:form action ="updateUser" modelAttribute="editUser">
            <input type = "text" name = "iD" class = "cred" placeholder="iD" value = "${editUser.id}" readonly><br><br>
            <input type = "text" name = "firstName" class = "cred" placeholder="First Name" value = "${editUser.firstName}" required><br><br>
            <input type = "text" name = "lastName" class = "cred" placeholder="Last Name" value = "${editUser.lastName}" required><br><br>
            <input type = "text" name = "email" class = "cred" placeholder="E-mail" value = "${editUser.email}" required><br><br>
            <input type = "number" name = "age" class = "cred" placeholder="Age" min = "10" max = "110" value = "${editUser.age}" required><br><br>



            <!--Choose your country -->
            Choose Your Country
            <select  name="country" id="countries" value = ${editUser.country}>
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
            </select><br><br>

            <!--Select favorite OS-->
            Languages:
            English<input type="checkbox" class = "language" name="languages" value="English">

            Albanian<input type="checkbox" class = "language" name="languages" value="Albanian">

            German<input type="checkbox" class = "language" name="languages" value="German"><br><br>

            Gender:
            <input type="radio" id="male" name="gender" value="M">
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="F">
            <label for="female">Female</label><br>
            <br><br>

            - <input type ="submit" class = "submitButton" value="Update Info"> -<br><br>


        </form:form>

        <form:form action = "deleteUser">

            <input type ="submit" class = "submitButton" value="Delete Account">

        </form:form>
        <a href = index.jsp>cancel</a>
    </ul>


</div>

</body>

</html>


