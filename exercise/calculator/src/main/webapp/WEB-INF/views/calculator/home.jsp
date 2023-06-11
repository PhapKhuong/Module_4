<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 06/11/2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator/show-result" method="post">
    <table>
        <tr>
            <input type="number" name="firstNumber" placeholder="The first number" required>
            <input type="number" name="secondNumber" placeholder="The second number" required>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="operation" value="+">
                <input type="submit" name="operation" value="-">
                <input type="submit" name="operation" value="x">
                <input type="submit" name="operation" value="/">
            </td>
        </tr>
    </table>
    <c:if test="${error!=null}">
        <h1>${error}</h1>
    </c:if>
    <p>Kết quả: ${result}</p>
</form>
</body>
</html>
