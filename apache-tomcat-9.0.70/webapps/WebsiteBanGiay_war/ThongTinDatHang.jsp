<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Thong tin dat hang</title>
    </head>
    <body>
    	<jsp:include page="Menu.jsp"></jsp:include>
        <div id="logreg-forms">
            <form class="form-signin" action="order" method="post">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Thong tin dat hang</h1>
                <c:if test="${error!=null }">
                 <div class="alert alert-danger" role="alert">
						 ${error}
				</div>
				</c:if>
				<c:if test="${mess!=null }">
                <div class="alert alert-success" role="alert">
				  	${mess}
				</div>
				</c:if>
                <label for="name">Name</label>
                <input name="name" type="text" id="name" class="form-control" placeholder="Name" required="" autofocus="">
                 <label for="phoneNumber">Phone number</label>
                <input name="phoneNumber" type="text" id="phoneNumber" class="form-control" placeholder="Phone number" required="" autofocus="">
                <label for="email">Email</label>
                <input name="email" type="text" id="email" class="form-control" placeholder="email" required="" autofocus="">
                <label for="deliveryAddress">Delivery Address</label>
                <input name="deliveryAddress" type="text" id="deliveryAddress" class="form-control" placeholder="Delivery Address" required="" autofocus="">
               
                <button class="btn btn-success btn-block" type="submit"><i class="fas fa-american-sign-language-interpreting"></i>Dat Hang</button>
                
          
                   <c:if test="${email!=null }">
                 <div class="alert alert-danger" role="alert">
						 ${email}
				</div>
				</c:if>
				
				
            </form>

           
            <br>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle() // display:block or none
                $('#logreg-forms .form-reset').toggle() // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $(() => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })
            
            window.addEventListener("load",function loadAmountCart(){
                        	 $.ajax({
                                 url: "/WebsiteBanGiay/loadAllAmountCart",
                                 type: "get", //send it through get method
                                 data: {
                                     
                                 },
                                 success: function (responseData) {
                                     document.getElementById("amountCart").innerHTML = responseData;
                                 }
                             });
                        },false);         
        </script>
    </body>
</html>