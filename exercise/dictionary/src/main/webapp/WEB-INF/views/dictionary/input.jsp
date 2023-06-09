<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 06/09/2023
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/show-result" method="post">
    <select name="choose">
        <option value="ev">E-V</option>
        <option value="ve">V-E</option>
    </select>
    <input type="text" name="word"/>
    <input type="submit" value="OK"/>
</form>
</body>
</html>
