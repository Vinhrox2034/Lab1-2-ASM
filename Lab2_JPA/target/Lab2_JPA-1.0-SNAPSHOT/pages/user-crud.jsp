<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User CRUD</title>
</head>
<body>

<h3><i>${message}</i></h3>

<c:url var="url" value="/user/crud" />

<form method="post">
    <input name="id" value="${user.id}" placeholder="ID"><br>
    <input name="password" value="${user.password}" placeholder="Password"><br>
    <input name="fullname" value="${user.fullname}" placeholder="Full name"><br>
    <input name="email" value="${user.email}" placeholder="Email"><br>

    <input type="radio" name="admin" value="true" ${user.admin ? 'checked' : ''}> Admin
    <input type="radio" name="admin" value="false" ${!user.admin ? 'checked' : ''}> User

    <hr>
    <button formaction="${url}/create">Create</button>
    <button formaction="${url}/update">Update</button>
    <button formaction="${url}/delete">Delete</button>
    <button formaction="${url}/reset">Reset</button>
</form>

<hr>

<table border="1" cellpadding="5">
    <tr>
        <th>Id</th>
        <th>Password</th>
        <th>Fullname</th>
        <th>Email</th>
        <th>Role</th>
        <th>Action</th>
    </tr>

    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.password}</td>
            <td>${u.fullname}</td>
            <td>${u.email}</td>
            <td>${u.admin ? 'Admin' : 'User'}</td>
            <td>
                <a href="${url}/edit/${u.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
