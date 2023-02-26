<%@ page import="java.util.List" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ page import="vn.edu.hcmuaf.fit.service.ManagerService" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.Loai" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/7/2023
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShopHandMade</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="build/css/manager.css" rel="stylesheet" type="text/css"/>
</head>
<style>
    img {
        width: 200px;
        height: 120px;
    }
</style>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Quản lý Sản phẩm</h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Thêm sản phẩm mới</span></a>
                    <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i>
                        <span>Xóa sản phẩm</span></a>
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
                <th>Mã sản phẩm</th>
                <th>Mã loại</th>
                <th>Tên sản phẩm</th>
                <th>Hình ảnh</th>
                <th>Giá mới</th>
                <th>Giá cũ</th>
                <th>Tình trạng</th>
                <th>Mô tả</th>
                <th>Tùy chỉnh</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<products> listP = (List<products>) request.getAttribute("listP");
                for (products pr : listP) {
            %>
            <tr>
                <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                            <label for="checkbox1"></label>
                        </span>
                </td>
                <td class="product-ma-<%=pr.getMasp()%>"><%=pr.getMasp()%>
                </td>
                <td class="product-loai-<%=pr.getMasp()%>"><%=pr.getMaloai()%>
                </td>
                <td class="product-ten-<%=pr.getMasp()%>"><%=pr.getTensp()%>
                </td>
                <td class="product-img-<%=pr.getMasp()%>">
                    <img src="<%=pr.getHinhanh()%>">
                </td>
                <td class="product-gia-moi-<%=pr.getMasp()%>"><%=pr.getGiamoi()%>
                </td>
                <td class="product-gia-cu-<%=pr.getMasp()%>"><%=pr.getGiacu()%>
                </td>
                <td class="product-tt-<%=pr.getMasp()%>"><%=pr.getTinhtrang()%>
                </td>
                <td class="product-mo-ta-<%=pr.getMasp()%>"><%=pr.getMota()%>
                </td>
                <td>
                    <a href="#editEmployeeModal" class="edit" data-toggle="modal">
                        <button value="<%=pr.getMasp()%>" style="display: none"></button>
                        <i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i></a>
                    <a href="http://localhost:8080/delete?pid=<%=pr.getMasp()%>" class="delete"
                       data-toggle="modal">
                        <i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a>
                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
        <div class="clearfix">
            <ul class="pagination">
                <li class="page-item active"><a href="#" class="page-link">1</a></li>
            </ul>
        </div>
    </div>
    <a href="admin.jsp">
        <button type="button" class="btn btn-primary">Trở về</button>
    </a>
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="addProduct" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm sản phẩm</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã sản phẩm</label>
                        <input name="id" type="text" class="form-control form-control-id" required>
                    </div>
                    <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input name="image" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Giá mới</label>
                        <input name="price_1" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Giá cũ</label>
                        <input name="price_2" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Tình trạng</label>
                        <textarea name="title" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <textarea name="description" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Loại</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <%
                                List<Loai> listC = (List<Loai>) request.getAttribute("listC");
                                for (Loai loai : listC) {
                            %>
                            <option value="<%=loai.getMaloai()%>"><%=loai.getTenloai()%>
                            </option>
                            <%}%>
                        </select>
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
            <form action="editProduct" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Sửa sản phẩm</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã sản phẩm</label>
                        <input  name="id" type="text" class="form-control pro-id" required>
                    </div>
                    <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input name="name" type="text" class="form-control pro-name" required>
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input name="image" type="text" class="form-control pro-img" required>
                    </div>
                    <div class="form-group">
                        <label>Giá mới</label>
                        <input name="price_1" type="text" class="form-control pro-price-1" required>
                    </div>
                    <div class="form-group">
                        <label>Giá cũ</label>
                        <input name="price_2" type="text" class="form-control pro-price-2" required>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <input name="description" type="text" class="form-control pro-des" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Thoát">
                    <input type="submit" class="btn btn-info" value="Lưu">
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
                    <h4 class="modal-title">Xóa sản phẩm</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Bạn có chắc chắn muốn xóa các sản phẩm này không?</p>
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
</a>
<script src="build/js/manager.js" type="text/javascript"></script>
</body>
</html>
