package vn.edu.hcmuaf.fit.controller;

import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.db.DB;

@WebServlet(name = "EditUserServlet", value = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    String name = "AUTH";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Lấy các thông tin từ request
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String nameUser = request.getParameter("nameUser");
        String emailUs = request.getParameter("emailUs");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
//        Date registrationDate = Date.valueOf(request.getParameter("RegistrationDate"));
        Integer roleUs = Integer.parseInt(request.getParameter("roleUs"));
        Integer active = Integer.parseInt(request.getParameter("active"));
        Integer userId = Integer.parseInt(request.getParameter("idU"));
        // Tạo một đối tượng User mới với các thông tin vừa lấy
        UserDao uDao = new UserDao();
        User user = new User();
        User u = uDao.findUserByMaUser(userId);
        user.setNameUser(nameUser);
        user.setEmailUs(emailUs);
        user.setPass(pass);
        user.setPhone(phone);
//        user.setRegistrationDate(registrationDate);
        user.setRoleUs(roleUs);
        user.setActive(active);
        user.setIdUser(userId);
//        uDao.updateUser(user);

        //user.setRegistrationDate(new Date(System.currentTimeMillis())); // Lấy ngày hiện tại làm ngày đăng ký

        // Thực hiện thêm user vào cơ sở dữ liệu
        UserDao userDao = new UserDao();
        userDao.EditUser(user);

        Log log = new Log(Log.INFO, -1, this.name, "", 0);
        log.setSrc(this.name + "Edit sussec");
        log.setContent("Edit sussec:- " + u.getEmailUs());
        log.setLevel(Log.INFO);
        DB.me().insert(log);
        // Chuyển hướng về trang danh sách user
        response.sendRedirect("/adminUser");
    }

}