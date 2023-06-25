package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Manager;
import vn.edu.hcmuaf.fit.service.RoleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminUser", value = "/adminUser")
public class AdminUserControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("QuanLyUser.jsp");
        RoleService role = new RoleService();
        List<Manager> m = role.getRole();   request.setAttribute("m", m);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
