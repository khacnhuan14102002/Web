<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
    <link rel="stylesheet" href="css/QuenMK.css">
</head>
<body>

<div class="logreg-forms">
    <h4>Nhập email của bạn</h4>
    <form action="forget" method="post">
        <input type="email" id="email" name="email" class="form-control" placeholder="Nhập email" required autofocus=""><br>
        <button class="btn">Gửi mật khẩu mới</button>
    </form>
</div>

</body>
</html>