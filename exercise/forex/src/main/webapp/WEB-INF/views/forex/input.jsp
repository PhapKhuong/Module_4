<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 06/08/2023
  Time: 02:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forex</title>
    <link rel="stylesheet" href="/asset/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="convert" method="post">
        <h4>Đổi tiền tệ</h4>
        <table>
            <tr>
                <td>Số lượng</td>
                <td><input type="number" name="quantity" required/></td>
            </tr>
            <td>Từ</td>
            <td>
                <select name="idFrom">
                    <c:forEach items="${monies}" var="money">
                        <option value="${money.id}">${money.name}</option>
                    </c:forEach>
                </select>
            </td>
            </tr>
            </tr>
            <td>Thành</td>
            <td>
                <select name="idTo">
                    <c:forEach items="${monies}" var="money">
                        <option value="${money.id}">${money.name}</option>
                    </c:forEach>
                </select>
            </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="OK"></td>
            </tr>
        </table>
    </form>
</div>
</body>
<script src="/asset/bootstrap.bundle.min.js"></script>
</html>
