<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 06/22/2023
  Time: 05:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/library.css"/>">
</head>
<body>
<div class="container">
    <b>Họ tên:</b>
    <span>${declaration.name}</span><br>
    <b>Năm sinh:</b>
    <span>${declaration.yearOfBirth}</span><br>
    <b>Giới tính:</b>
    <span>${declaration.gender}</span><br>
    <b>Quốc tịch:</b>
    <span>${declaration.nationality}</span><br>
    <b>Số CMND:</b>
    <span>${declaration.nationalityId}</span><br>
    <b>Phương tiện đi lại:</b>
    <span>${declaration.transportVehicle}</span><br>
    <b>Số hiệu phương tiện:</b>
    <span>${declaration.vehicleId}</span><br>
    <b>Số ghế:</b>
    <span>${declaration.seatId}</span><br>
    <b>Ngày khởi hành:</b>
    <span>${declaration.startDate}</span><br>
    <b>Ngày kết thúc:</b>
    <span>${declaration.endDate}</span><br>
</div>
</body>
<script src="<c:url value="/assets/js/bootstrap.bundle.min.js"/>"></script>
</html>
