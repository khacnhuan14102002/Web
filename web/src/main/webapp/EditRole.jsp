<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.UserDao" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.Manager" %><%--
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
      <%Manager m = (Manager) request.getAttribute("ma");%>

      <form action="editrole" method="post">
        <div class="modal-header">
          <h4 class="modal-title">CHỈNH QUYỀN</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>ID USER</label>
            <input name="id" type="text" class="form-control role-id" value="<%=m.getIdU()%>">
          </div>
          <div class="form-group">
            <label>MÃ QUẢN LÝ</label>required
            <input name="id_ql" type="text" class="form-control cat-name" value="<%=m.getManager()%>">
          </div>
          <div class="form-group">
            <label>CHO XÓA</label>
            <input name="x" type="text" class="form-control cat-name" value="<%=m.getIsdelete()%>">
          </div>
          <div class="form-group">
            <label>CHO SỬA</label>
            <input name="s" type="text" class="form-control cat-name" value="<%=m.getIsedit()%>">
          </div>
          <div class="form-group">
            <label>CHO THÊM</label>
            <input name="t" type="text" class="form-control cat-name" value="<%=m.getIsadd()%>">
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Thoát">
            <input type="submit" class="btn btn-info" value="Lưu">
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>