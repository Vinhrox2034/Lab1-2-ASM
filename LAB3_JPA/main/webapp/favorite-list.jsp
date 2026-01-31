<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Favorite Videos</title>

    <style>
        body {
            font-family: Arial;
            background: #f4f6f8;
            padding: 20px;
        }
        h2 {
            text-align: center;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        th {
            background: #2c3e50;
            color: white;
            padding: 12px;
        }
        td {
            padding: 10px;
            border-bottom: 1px solid #eee;
        }
        tr.main {
            cursor: pointer;
        }
        tr.main:hover {
            background: #ecf3ff;
        }
        tr.detail td {
            background: #fafafa;
        }
    </style>

    <script>
        function toggle(id) {
            const r = document.getElementById(id);
            r.style.display = (r.style.display === "none") ? "table-row" : "none";
        }
    </script>
</head>

<body>

<h2>📊 Danh sách video yêu thích</h2>

<table>
    <tr>
        <th>Video ID</th>
        <th>Tiêu đề</th>
        <th>Số lượt thích</th>
    </tr>

    <c:forEach var="row" items="${items}" varStatus="st">
        <tr class="main" onclick="toggle('d${st.index}')">
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
        </tr>

        <tr id="d${st.index}" class="detail" style="display:none">
            <td colspan="3">
                <b>Users liked this video:</b>
                <ul>
                    <c:forEach var="u" items="${favoriteMap[row[0]]}">
                        <li>${u.email}</li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
