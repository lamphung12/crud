<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 5/31/2022
  Time: 3:37 PM
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
    <div class="form-group">
        <label for="exampleFormControlInput1">Name</label>
        <input type="text" class="form-control" id="exampleFormControlInput1"
               placeholder="Tên sản phẩm" name="name" value="${product.name}" >
        <label for="exampleFormControlInput1">Price</label>
        <input  class="form-control" id="exampleFormControlInput"
               placeholder="Gía sản phẩm" name="price" value="${product.price}">
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Category</label>
        <select class="form-control" id="exampleFormControlSelect1" name="cId">
            <c:forEach items="${category}" var="p">
                <option value="${p.id}"> ${p.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
