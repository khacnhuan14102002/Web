package vn.edu.hcmuaf.fit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.service.QuanLyUser;

@WebServlet(value = { "/QuanLyUserControl" })
public class QuanLyUserControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");

        if (command != null && !command.isEmpty()) {
            switch (command) {
                case "add":
                    addUser(request, response);
                    break;
                case "edit":
                    editUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    break;
            }
        }
    }

    // Thêm người dùng
    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameUser = request.getParameter("NameUser");
        String emailUs = request.getParameter("EmailUs");
        String pass = request.getParameter("Pass");
        String phone = request.getParameter("Phone");
        User user = new User();
        QuanLyUser.addUser(user);
        response.sendRedirect("QuanLyUser.jsp");
    }

    // Sửa thông tin người dùng
    private void editUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String nameUser = request.getParameter("NameUser");
        String emailUs = request.getParameter("EmailUs");
        String phone = request.getParameter("Phone");
        int roleUs = Integer.parseInt(request.getParameter("RoleUs"));
        int active = Integer.parseInt(request.getParameter("Active"));
        QuanLyUser.capNhatUser(nameUser, emailUs, phone, roleUs, active, idUser);
        response.sendRedirect("QuanLyUser.jsp");
    }

    // Xóa người dùng
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        QuanLyUser.deleteUser(idUser);
        response.sendRedirect("QuanLyUser.jsp");
    }
}

