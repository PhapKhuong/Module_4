<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 06/11/2023
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display condiment</title>
</head>
<body>
<c:forEach items="${results}" var="result">
    <h2>${result}</h2>
</c:forEach>
<a href="/sandwich/choose-condiment">Chọn gia vị</a>
</body>
</html>
