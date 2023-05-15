<%--
  Created by IntelliJ IDEA.
  User: Mai Thi
  Date: 2023-04-13
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Thêm USER</title>
</head>
<body>
<div class="container" style="margin-top: 10px;">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
        <div class="col-sm-12">
            <h2>Dang Ky</h2>
            <form action="AddUserServlet" method="post">
                <input type="hidden" class="form-control" name="action" value="" >
                <div class="form-group">
                    <label>UserName</label>
                    <input type="text" class="form-control" name="NamUser" value=""  placeholder="Enter UserName">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input  class="form-control" name="EmailUs" value="" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" class="form-control" name="Pass" value="" placeholder="Enter password">
                </div>
                <div class="form-group">
                    <label>Phone: </label>
                    <input class="form-control" name="Phone" value="" placeholder="Enter Phone">
                </div>
                <div class="form-group">
                    <label>Role:</label>
                    <select class="form-control" name="RoleUs">
                        <option value="1">Admin</option>
                        <option value="0">User</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Active:</label>
                    <select class="form-control" name="Active">
                        <option value="1">Yes</option>
                        <option value="0">No</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="/adminUser"> <button href="" type="reset" class="btn btn-primary">Cancel</button> </a>

            </form>
        </div>
    </div>
</div>

</body>
</html>
