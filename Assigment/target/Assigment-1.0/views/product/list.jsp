<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container py-4">
    <h3 class="mb-4"> Popular Products</h3>

    <div class="row row-cols-1 row-cols-md-4 g-4">
        <c:forEach items="${products}" var="p">
            <div class="col">
                <div class="card h-100 shadow-sm">
                    <img src="${p.image}"
                         alt="${p.name}"
                         class="card-img-top"
                         style="height:200px; object-fit:cover"
                         onerror="this.src='https://product.hstatic.net/200000722513/product/o-cung-hdd-18tb-western-digital_17bc422fad9b4f8fb51ec439e3f63a4a_master.png'">

                    <div class="card-body">
                        <h6 class="card-title">${p.name}</h6>
                        <p class="fw-bold text-danger">
                                ${p.price} VND
                        </p>
                        <a href="product/detail?id=${p.productId}"
                           class="btn btn-outline-primary btn-sm w-100">
                            View Detail
                        </a>
                    </div>
                    <div class="card-footer text-muted small">
                         ${p.views} views
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
