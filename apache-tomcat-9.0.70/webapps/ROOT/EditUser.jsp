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
    <title>Edit User</title>
</head>
<body>
<div class="container" style="margin-top: 10px;">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <h1>Sửa thông tin user</h1>
           <%User u = (User) request.getAttribute("user1");%>
            <form action="EditUserServlet" method="post">

                <div class="form-group">
                    <label>Tên:</label>
                    <input type="text" name="nameUser" value="<%=u.getNameUser()%>"><br>
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <input type="text" name="emailUs" value="<%=u.getEmailUs()%>"><br>
                </div>
                <div class="form-group">
                    <label>Mật khẩu:</label>
                    <input type="password" name="pass" value="<%=u.getPass()%>"><br>
                </div>
                <div class="form-group">
                    <label>Điện thoại:</label>
                    <input type="text" name="phone" value="<%=u.getPhone()%>"><br>
                </div>
                <%--                <div class="form-group">--%>
                <%--                <label>Ngày đăng ký:</label>--%>
                <%--                <input type="text" name="registrationDate" value="${ user.getRegistrationDate() }"><br>--%>
                <%--                </div>--%>
                <div class="form-group">
                    <label>Vai trò:</label>
                    <select name="roleUs">
                        <option value="1" >1</option>
                        <option value="0" >0</option>
                    </select><br>
                </div>
                <div class="form-group">
                    <label>Hoạt động:</label>
                    <input type="radio" name="active" value="1" <%= (u.getActive() == 1) ? "checked" : "" %>>1
                    <input type="radio" name="active" value="0" <%= (u.getActive() == 0) ? "checked" : ""%>>0<br>
                </div>
                <div class="form-group">

                    <input type="hidden" name="idU" value="<%=u.getIdUser()%>"><br>
                </div>

                <button type="submit">Lưu</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>