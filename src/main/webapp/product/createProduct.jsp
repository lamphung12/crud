<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 5/30/2022
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h5>Name</h5>
    <input class="form-control" type="text" name="name">
    <h5>Price</h5>
    <input class="form-control" type="text" name="price">
    <h5>Category</h5>
    <select class="form-control" name="categoryId">
        <c:forEach items="${category}" var="p">
            <option value="${p.id}"> ${p.name}</option>
        </c:forEach>
    </select>
    <button class="btn btn-primary mt-2">Create</button>

</form>
</body>
</html>
