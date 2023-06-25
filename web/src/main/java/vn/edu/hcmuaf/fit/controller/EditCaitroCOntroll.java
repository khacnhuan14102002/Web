package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Manager;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.service.RoleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "editvaitro", value = "/editvaitro")
public class EditCaitroCOntroll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("uid"));
        RoleService ro = new RoleService();
        Manager ma= ro.getRoleId(id);
        request.setAttribute("ma",ma);

        request.getRequestDispatcher("EditRole.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
