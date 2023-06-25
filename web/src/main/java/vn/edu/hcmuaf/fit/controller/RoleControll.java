package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Manager;
import vn.edu.hcmuaf.fit.service.RoleService;

import javax.management.relation.Role;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "role", value = "/role")
public class RoleControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoleService role = new RoleService();
        List<Manager> m = role.getRole();   request.setAttribute("m", m);
        request.getRequestDispatcher("Role.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
