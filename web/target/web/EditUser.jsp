<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Mai Thi
  Date: 2023-04-20
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Edit User</title>
    <style>
        input {
            padding: 8px;
            border-radius: 8px;
            width: 95%;
        }
    </style>
</head>
<body style="background-color: beige">
<div class="container" style="margin-top: 60px" >
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 35%; margin: 0 auto; padding: 30px; background-color: #ffffc9">
        <div class="col-sm-12" style="background-color: #ffffc9;">

            <h1 style="text-align: center; margin-bottom: 25px;">Sửa thông tin user</h1>
            <%User u = (User) request.getAttribute("user1");%>

            <form action="EditUserServlet" method="post" style="background-color: #ffffc9; ">
                <div class="form-group">
                    <label>Tên:</label> </br>
                    <input class="text" type="text" name="nameUser" value="<%=u.getNameUser()%>"><br>
                </div>
                <div class="form-group">
                    <label>Email:</label></br>
                    <input class="text" type="text" name="emailUs" value="<%=u.getEmailUs()%>"><br>
                </div>
                <div class="form-group">
                    <label>Mật khẩu:</label></br>
                    <input class="text" type="password" name="pass" value="<%=u.getPass()%>"><br>
                </div>
                <div class="form-group">
                    <label>Điện thoại:</label></br>
                    <input class="text" type="text" name="phone" value="<%=u.getPhone()%>"><br>
                </div>
                <%--                <div class="form-group">--%>
                <%--                <label>Ngày đăng ký:</label>--%>
                <%--                <input type="text" name="registrationDate" value="${ user.getRegistrationDate() }"><br>--%>
                <%--                </div>--%>
                <div class="form-group">
                    <label>Vai trò:</label>
                    <select class="text"  name="roleUs" style="padding: 8px;">
                        <option value="1" > Admin </option>
                        <option value="0" > Khách Hàng</option>
                    </select><br>
                </div>
                <div class="form-group">
                    <label>Hoạt động: </label>
                    <select class="text"  name="active" style="padding: 8px; ">
                        <option value="1" > Hoạt động </option>
                        <option value="0" > Không hoạt động</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="hidden" name="idU" value="<%=u.getIdUser()%>"><br>
                </div>
                <button type="submit" style="text-align: center; padding: 8px; margin-left: 45%;">Lưu</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>