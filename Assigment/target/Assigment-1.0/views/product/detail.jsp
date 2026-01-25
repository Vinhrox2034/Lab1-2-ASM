<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-4">
    <div class="row">
        <div class="col-md-5">
            <img src="${product.image}"
                 class="img-fluid rounded shadow"
                 alt="${product.name}"
                 onerror="this.src='https://product.hstatic.net/200000722513/product/o-cung-hdd-18tb-western-digital_17bc422fad9b4f8fb51ec439e3f63a4a_master.png'">

        </div>

        <div class="col-md-7">
            <h2>${product.name}</h2>
            <p>${product.description}</p>

            <h4 class="text-danger">${product.price} VND</h4>

            <p>
                Views: <strong>${product.views}</strong> |
                ️ Likes: <strong>${likes}</strong>
            </p>

            <hr>

            <!-- LIKE -->
            <c:if test="${not empty sessionScope.user}">
                <form action="${pageContext.request.contextPath}/favorite" method="post" class="d-inline">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <button class="btn ${liked ? 'btn-secondary' : 'btn-danger'}">
                        <c:choose>
                            <c:when test="${liked}">💔 Unlike</c:when>
                            <c:otherwise>❤️ Like</c:otherwise>
                        </c:choose>
                    </button>
                </form>
            </c:if>

            <c:if test="${empty sessionScope.user}">
                <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-outline-secondary">
                    Login to Like
                </a>
            </c:if>

            <!-- SHARE -->
            <form action="${pageContext.request.contextPath}/share" method="post" class="mt-3">
                <input type="hidden" name="productId" value="${product.productId}">
                <div class="input-group">
                    <input type="email" name="emails" class="form-control"
                           placeholder="Enter email to share" required>
                    <button class="btn btn-primary">📤 Share</button>
                </div>
            </form>

            <br>
            <a href="${pageContext.request.contextPath}/products" class="btn btn-link">
                ⬅ Back to list
            </a>
        </div>
    </div>
</div>
