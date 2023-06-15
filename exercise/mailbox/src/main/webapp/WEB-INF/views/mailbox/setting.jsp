<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 06/15/2023
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="setting" method="post">
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="language">
                    <c:forEach items="${languages}" var="language">
                        <form:option value="${language}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>show
                <form:select path="size">
                    <c:forEach items="${pageSizes}" var="size">
                        <form:option value="${size}"/>
                    </c:forEach>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:checkbox path="spamFilter" value="Enable spams filter"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature" rows="4" cols="20"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Update</form:button>
                <a href="/mailbox/setting">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
<h4>${msg}</h4>
</body>
</html>
