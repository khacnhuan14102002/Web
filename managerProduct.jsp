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
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link href="../build/css/manager.css" rel="stylesheet" type="text/css"/>
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
                <th>Tên sản phẩm</th>
                <th>Hình ảnh</th>
                <th>Giá bán</th>
                <th>Tùy chỉnh</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach begin="1" end="5" var="o">
                <tr>
                    <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                            <label for="checkbox1"></label>
                        </span>
                    </td>
                    <td>1</td>
                    <td>Giày thể thao</td>
                    <td>
                        <img src="https://image.yes24.vn/Upload/ProductImage/GmarketSport/2058803_L.jpg?width=550&height=550">
                    </td>
                    <td>100 $</td>
                    <td>
                        <a href="#editEmployeeModal" class="edit" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a href="#deleteEmployeeModal" class="delete" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach begin="1" end="5" var="o">
                <tr>
                    <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox2" name="options[]" value="2">
                            <label for="checkbox1"></label>
                        </span>
                    </td>
                    <td>1</td>
                    <td>Giày thể thao</td>
                    <td>
                        <img src="https://image.yes24.vn/Upload/ProductImage/GmarketSport/2058803_L.jpg?width=550&height=550">
                    </td>
                    <td>100 $</td>
                    <td>
                        <a href="#editEmployeeModal" class="edit" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a href="#deleteEmployeeModal" class="delete" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="clearfix">
            <div class="hint-text">Hiển thị <b>5</b> trên số <b>100</b> sản phẩm</div>
            <ul class="pagination">
                <li class="page-item disabled"><a href="#">Trước</a></li>
                <li class="page-item active"><a href="#" class="page-link">1</a></li>
                <li class="page-item"><a href="#" class="page-link">2</a></li>
                <li class="page-item"><a href="#" class="page-link">3</a></li>
                <li class="page-item"><a href="#" class="page-link">4</a></li>
                <li class="page-item"><a href="#" class="page-link">5</a></li>
                <li class="page-item"><a href="#" class="page-link">Kế tiếp</a></li>
            </ul>
        </div>
    </div>
    <a href="admin.html">
        <button type="button" class="btn btn-primary">Trở về</button>
    </a>
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm sản phẩm</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input name="image" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Giá bán</label>
                        <input name="price" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Ghi chú</label>
                        <textarea name="title" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <textarea name="description" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Loại</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach begin="1" end="3" var="o">
                                <option value="1">Dreamcatcher</option>
                                <option value="1">Móc khóa</option>
                                <option value="1">Ốp lưng</option>
                                <option value="1">Sản phẩm khác</option>
                                <option value="1">Thiệp</option>
                            </c:forEach>
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
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Sửa sản phẩm</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input name="image" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Giá bán</label>
                        <input name="price" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <input name="description" type="text" class="form-control" required>
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
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
</a>
<script src="../build/js/manager.js" type="text/javascript"></script>
</body>
</html>
