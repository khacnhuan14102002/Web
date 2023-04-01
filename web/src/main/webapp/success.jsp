<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="col-sm-5 container">
<form action="user" method="post">
	<h4>Cập nhật thông tin</h4>
	<label>Họ tên</label>
	<input name="fullname" type="text" class="form-control" value="${user.getNameUser()}">
	<label>email</label>
	<input name="email" type="text" class="form-control" value="${user.getEmailUs()}">
	<label>Password</label>
	<input name="pass" type="text" class="form-control" value="${user.getPass()}">
	<label>Số điện thoại</label>
	<input name="sdt" type="text" class="form-control" value="${user.getPhone()}">
	<button class="btn btn-success">Cập nhật</button>

</form>
</div>
</body>
</html>