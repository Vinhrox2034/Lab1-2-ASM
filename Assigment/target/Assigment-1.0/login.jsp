<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card p-4 shadow" style="width:380px">
        <h4 class="text-center mb-3">Login</h4>

        <form action="login" method="post">
            <input class="form-control mb-3" name="username" placeholder="Username">
            <input type="password" class="form-control mb-3" name="password" placeholder="Password">
            <button class="btn btn-primary w-100">Login</button>
        </form>

        <p class="text-danger mt-3 text-center">${message}</p>
    </div>
</div>

</body>
</html>
