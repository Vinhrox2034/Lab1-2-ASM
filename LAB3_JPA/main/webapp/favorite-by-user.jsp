<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Favorite By User</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
            padding: 20px;
        }
        form {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 70%;
            margin: auto;
            border-collapse: collapse;
            background: white;
        }
        th {
            background: #34495e;
            color: white;
            padding: 10px;
        }
        td {
            padding: 8px;
            border-bottom: 1px solid #eee;
        }
    </style>
</head>
<body>

<h2>❤️ Favorites By User</h2>

<form method="get" action="favorite-by-user">
    <input type="text" name="id" placeholder="Enter user ID" required>
    <button type="submit">View</button>
</form>

<c:if test="${not empty user}">
    <h3>User: ${user.email}</h3>

    <table border="1" cellpadding="6">
        <tr>
            <th>Video ID</th>
            <th>Title</th>
            <th>Like Date</th>
        </tr>

        <c:forEach var="f" items="${user.favorites}">
            <tr>
                <td>${f.video.id}</td>
                <td>${f.video.title}</td>
                <td>${f.likeDate}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty user}">
    <p style="color:red">${message}</p>
</c:if>


</body>
</html>
