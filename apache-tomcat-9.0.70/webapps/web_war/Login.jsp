<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
 <link href="<c:url value='/css/style1.css'/>" rel="stylesheet"
	type="text/css" />
  <title>Tài khoản</title>
<%--  <link rel="stylesheet" href="css/Login.css">--%>
  <script src="js/Login.js"></script>
</head>
<body>
<div id="logreg-forms">

  <form class="form-signin" method="post">
    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Đăng nhập</h1>

    <div class="social-login">
      <button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Đăng nhập với Facebook</span> </button>
      <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Đăng nhập với Google+</span> </button>
    </div>
    <p style="text-align:center"> Hoặc  </p>

    <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Nhập email" required="" autofocus="">
    <input name="pass" type="password" id="inputPassword" class="form-control" placeholder="Mật khẩu" required="">

    <button class=" bt btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Đăng nhập</button>
    <a href="forget" id="forgot_pswd">Quên mật khẩu?</a>
    <hr>
    <!-- <p>Don't have an account!</p>  -->
    <a class="bt btn btn-primary btn-block" href="regis"><i class="fas fa-user-plus"></i> Đăng kí</a>
  </form>

  <form action="/reset/password/" class="form-reset">
    <input type="email" id="resetEmail" class="form-control" placeholder="Nhập email" required="" autofocus="">
    <a class="btn btn-primary btn-block" href="forget">quên mật khẩu</a>
    <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Trở về</a>
  </form>

  
  <br>
</div>
<script type="text/javascript">
var errors = <%=request.getAttribute("errorlogin")%>;
if(errors != null){
	alert(errors)
}
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="/script.js"></script>
</body>
</html>