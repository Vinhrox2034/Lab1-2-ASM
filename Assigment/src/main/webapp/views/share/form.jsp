<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Share Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container py-5">
    <div class="card shadow p-4 mx-auto" style="max-width:500px">
        <h5>📧 Share Product</h5>

        <form action="../share" method="post">
            <input type="hidden" name="productId" value="${param.productId}">
            <input class="form-control mb-3"
                   name="emails"
                   placeholder="Email1, Email2, Email3">
            <button class="btn btn-success w-100">Share</button>
        </form>
    </div>
</div>

</body>
</html>
