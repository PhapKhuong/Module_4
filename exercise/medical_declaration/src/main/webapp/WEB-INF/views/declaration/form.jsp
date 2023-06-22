<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phapk
  Date: 06/22/2023
  Time: 05:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/assets/css/library.css"/>">
</head>
<body>
<h3 class="header">TỜ KHAI Y TẾ</h3>
<h4 class="header"> Đây là tài liệu quan trọng, thông tin của Anh/Chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để
    phòng chống dịch
    bệnh truyền nhiễm</h4>
<h5 class="header">Khuyến cáo khai báo thông tin sai là vi pham pháp luật Việt Nam và có thể bị xử lý
    hình sự</h5>


<form:form action="/medical-declaration/save" method="post" modelAttribute="declaration">
    <div class="full">
        <span>Họ tên (ghi chữ IN HOA)</span>
        <span class="red"> (*)</span>
        <form:input path="name" cssClass="full" required="required"/>
    </div>
    <br><br>
    <div class="full">
        <div class="divide">
            <span>Năm sinh</span>
            <span class="red">(*)</span>
            <form:select path="yearOfBirth" cssClass="full">
                <form:options items="${yearOfBirth}"/>
            </form:select>
        </div>

        <div class="divide">
            <span>Giới tính</span>
            <span class="red">(*)</span>
            <form:select path="gender" cssClass="full">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nữ</form:option>
            </form:select>
        </div>

        <div class="divide">
            <span>Quốc gia</span>
            <span class="red">(*)</span>
            <form:select path="nationality" cssClass="full">
                <form:options items="${nationality}"/>
            </form:select>
        </div>
    </div>
    <br><br><br><br>

    <div class="full">
        <span>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</span>
        <span class="red"> (*)</span>
        <form:input path="nationalityId" cssClass="full" required="required"/>
    </div>
    <br><br>
    <div class="full">
        <span>Thông tin đi lại</span>
        <span class="red"> (*)</span> <br>
        <form:radiobuttons path="transportVehicle" items="${transportVehicle}" required="required"/>
    </div>
    <br><br>
    <div class="full">
        <div class="half">
            <span>Số hiệu phương tiện</span>
            <form:input path="vehicleId" cssClass="full"/>
        </div>
        <div class="half">
            <span>Số ghế</span>
            <form:input path="seatId" cssClass="full"/>
        </div>
    </div>
    <br><br><br><br>
    <div class="full">
        <div class="half">
            <span>Ngày khời hành</span>
            <span class="red"> (*)</span>
            <form:input path="startDate" type="date" cssClass="full" required="required"/>
        </div>
        <div class="half">
            <span>Ngày kết thúc</span>
            <span class="red"> (*)</span>
            <form:input path="endDate" type="date" cssClass="full" required="required"/>
        </div>
    </div>
    <br><br>
    <form:button>Save</form:button>
</form:form>
</body>
<script src="<c:url value="/assets/js/bootstrap.bundle.min.js"/>"></script>
</html>
