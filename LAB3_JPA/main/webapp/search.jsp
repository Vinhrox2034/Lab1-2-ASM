<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Search Video</title>
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
            background: white;
            border-collapse: collapse;
        }
        th {
            background: #16a085;
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

<h2 style="text-align:center">🔍 Search Video</h2>

<form action="search-video" method="get">
    <input type="text" name="keyword" placeholder="Enter title..." required>
    <button type="submit">Search</button>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Views</th>
    </tr>

    <c:forEach var="v" items="${videos}">
        <tr>
            <td>${v.id}</td>
            <td>${v.title}</td>
            <td>${v.views}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
