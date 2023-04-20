package vn.edu.hcmuaf.fit.controller;

import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.dao.UserDao;

@WebServlet(name = "EditUserServlet", value = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Lấy các thông tin từ request
        Integer userId = Integer.parseInt(request.getParameter("IdUser"));
        String nameUser = request.getParameter("NameUser");
        String emailUs = request.getParameter("EmailUs");
        String pass = request.getParameter("Pass");
        String phone = request.getParameter("Phone");
        Date registrationDate = Date.valueOf(request.getParameter("RegistrationDate"));
        Integer roleUs = Integer.parseInt(request.getParameter("RoleUs"));
        Integer active = Integer.parseInt(request.getParameter("Active"));

        // Tạo một đối tượng User mới với các thông tin vừa lấy
        UserDao uDao = new UserDao();
        User user = new User();

        user.setIdUser(userId);
        user.setNameUser(nameUser);
        user.setEmailUs(emailUs);
        user.setPass(pass);
        user.setPhone(phone);
        user.setRegistrationDate(registrationDate);
        user.setRoleUs(roleUs);
        user.setActive(active);
        uDao.updateUser(user);

        user.setRegistrationDate(new Date(System.currentTimeMillis())); // Lấy ngày hiện tại làm ngày đăng ký

        // Thực hiện thêm user vào cơ sở dữ liệu
        UserDao userDao = new UserDao();
        userDao.EditUser(user);

        // Chuyển hướng về trang danh sách user
        response.sendRedirect("QuanLyUser.jsp");
    }

}
