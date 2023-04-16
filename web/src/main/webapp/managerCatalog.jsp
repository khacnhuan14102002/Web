<%@ page import="vn.edu.hcmuaf.fit.bean.category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kim_Tuyet
  Date: 4/2/2023
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quản lý danh mục</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="build/css/manager.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Quản lý Danh Mục</h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Thêm danh mục mới</span></a>
                    <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i>
                        <span>Xóa danh mục</span></a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <span class="custom-checkbox">
                        <input type="checkbox" id="selectAll">
                        <label for="selectAll"></label>
                    </span>
                </th>
                <th>Mã loại</th>
                <th>Tên loại</th>
                <th>Tùy chỉnh</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<category> listC = (List<category>) request.getAttribute("listC");
                for (category cat : listC) {
            %>
            <tr>
                <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                            <label for="checkbox1"></label>
                        </span>
                </td>
                <td class="category-ma-<%=cat.getIdCat()%>"><%=cat.getIdCat()%>
                </td>
                <td class="category-ten-<%=cat.getNameCat()%>"><%=cat.getNameCat()%>
                </td>
                <td>
                    <a href="#editEmployeeModal" class="edit" data-toggle="modal">
                        <button value="<%=cat.getIdCat()%>" style="display: none"></button>
                        <i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i></a>
                    <a href="http://localhost:8080/deleteCatalog?cid=<%=cat.getIdCat()%>" class="delete"
                       data-toggle="modal">
                        <i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a>
                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
    </div>
    <a href="admin.jsp">
        <button type="button" class="btn btn-primary">Trở về</button>
    </a>
</div>
<!-- Add Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="addCatalog" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm danh mục</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã loại</label>
                        <input name="id" type="text" class="form-control form-control-id" required>
                    </div>
                    <div class="form-group">
                        <label>Tên loại</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-success" value="Thêm">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="editCatalog" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Sửa danh mục</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã loại</label>
                        <input name="id" type="text" class="form-control cat-id" required>
                    </div>
                    <div class="form-group">
                        <label>Tên loại</label>
                        <input name="name" type="text" class="form-control cat-name" required>
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
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Xóa danh mục</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Bạn có chắc chắn muốn xóa các danh mục này không?</p>
                    <p class="text-warning"><small>Hành động này không thể được hoàn tác</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Thoát">
                    <input type="submit" class="btn btn-danger" value="Xóa">
                </div>
            </form>
        </div>
    </div>
</div>
<script src="build/js/manager.js" type="text/javascript"></script>
</body>
</html>
