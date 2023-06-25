package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Manager;
import vn.edu.hcmuaf.fit.service.RoleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addrole", value = "/addrole")
public class AddroleCOntroll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int pid = Integer.parseInt(request.getParameter("id"));
        String id = request.getParameter("id");
        String ql = request.getParameter("id_ql");
        String xoa = request.getParameter("x");
        String sua = request.getParameter("s");;
        String them = request.getParameter("t");
        RoleService role = new RoleService();
        Manager mn = new Manager();
        mn.setIdU((pid));
        mn.setManager(Integer.parseInt(ql));
        mn.setIsdelete(Integer.parseInt(xoa));
        mn.setIsedit(Integer.parseInt(sua));
        mn.setIsadd(Integer.parseInt(them));
        role.adddwish(mn);
        response.sendRedirect("/role");
    }
}
