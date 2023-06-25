<%@ page import="vn.edu.hcmuaf.fit.bean.category" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.Manager" %><%--
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
                <th>ID USER</th>
                <th>ID QUẢN LÝ</th>
                <th>CHO XÓA</th>
                <th>CHO THÊM</th>
                <th>CHO SỬA</th>

            </tr>
            </thead>
            <tbody>
            <%


                List<Manager> listC = (List<Manager>) request.getAttribute("m");
                for (Manager  ma: listC) {
            %>
            <tr>
                <td>
                        <span class="custom-checkbox">
                            <input type="checkbox"  name="id" value="<%=ma.getIdU()%>">
                            <label for="checkbox1"></label>
                        </span>
                </td>
                <td class="category-ma-<%=ma.getIdU()%>"><%=ma.getIdU()%>
                </td>
                <td class="category-ten-<%=ma.getManager()%>"><%=ma.getManager()%>
                </td>
                <td class=""><%=ma.getIsdelete()%>
                </td>
                <td class=""><%=ma.getIsadd()%>
                </td>
                <td class=""><%=ma.getIsedit()%>
                </td>
                <td>
                    <button class="add-to-wishlist"><a
                            href="editvaitro?uid=<%=ma.getIdU()%>"><i
                            class="fa fa-wrench"></i></a>
                    </button>

                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
    </div>
    <a href="/adminpage">
        <button type="button" class="btn btn-primary">Trở về</button>
    </a>
</div>
<!-- Add Modal HTML -->

<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="addrole" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">CHỈNH QUYỀN</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>ID USER</label>
                        <input name="id" type="text" class="form-control cat-id" required>
                    </div>
                    <div class="form-group">
                        <label>MÃ QUẢN LÝ</label>
                        <input name="id_ql" type="text" class="form-control cat-name" required>
                    </div>
                    <div class="form-group">
                        <label>CHO XÓA</label>
                        <input name="x" type="text" class="form-control cat-name" required>
                    </div>
                    <div class="form-group">
                        <label>CHO SỬA</label>
                        <input name="s" type="text" class="form-control cat-name" required>
                    </div>
                    <div class="form-group">
                        <label>CHO THÊM</label>
                        <input name="t" type="text" class="form-control cat-name" required>
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

<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="editrole" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">CHỈNH QUYỀN</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>ID USER</label>
                        <input name="id" type="text" class="form-control role-id" required>
                    </div>
                    <div class="form-group">
                        <label>MÃ QUẢN LÝ</label>
                        <input name="id_ql" type="text" class="form-control cat-name" required>
                    </div>
                    <div class="form-group">
                        <label>CHO XÓA</label>
                        <input name="x" type="text" class="form-control cat-name" required>
                    </div>
                    <div class="form-group">
                        <label>CHO SỬA</label>
                        <input name="s" type="text" class="form-control cat-name" required>
                    </div>
                    <div class="form-group">
                        <label>CHO THÊM</label>
                        <input name="t" type="text" class="form-control cat-name" required>
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
<
<!-- Delete Modal HTML -->

<script src="build/js/managerrole.js" type="text/javascript"></script>
</body>
</html>
