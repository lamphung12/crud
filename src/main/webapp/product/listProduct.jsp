<%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 5/30/2022
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${product}" var="pr">
 <h1>${pr.id},${pr.name},${pr.price},${pr.categoryId.name}</h1>
</c:forEach>
</body>
</html>
