package vn.edu.hcmuaf.fit.controller;

import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.bean.User;
@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy các thông tin từ request
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String nameUser = request.getParameter("NamUser");
        String emailUs = request.getParameter("EmailUs");
        String pass = request.getParameter("Pass");
        String phone = request.getParameter("Phone");
        Integer roleus = Integer.parseInt(request.getParameter("RoleUs"));
        Integer active = Integer.parseInt(request.getParameter("Active"));

        // Tạo một đối tượng User mới với các thông tin vừa lấy
        User user = new User();
        user.setNameUser(nameUser);
        user.setEmailUs(emailUs);
        user.setPass(pass);
        user.setPhone(phone);
        user.setRoleUs(roleus);
        user.setActive(active);

        user.setRegistrationDate(new Date(System.currentTimeMillis())); // Lấy ngày hiện tại làm ngày đăng ký

        // Thực hiện thêm user vào cơ sở dữ liệu
        UserDao userDao = new UserDao();
        userDao.addUser(user);

        // Chuyển hướng về trang danh sách user
        response.sendRedirect("/adminUser");
    }
}