package vn.edu.hcmuaf.fit.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.db.DB;

@WebServlet(name = "deleteUser", value = "/deleteUser")

public class deleteUser extends HttpServlet {
    String name = "AUTH";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        User u =UserDao.getUser(idUser);
        UserDao.deleteUser(idUser);
        Log log = new Log(Log.INFO, -1, this.name, "", 0);
        log.setSrc(this.name + "Delete sussec");
        log.setContent("Delete sussec:- " + u.getEmailUs());
        log.setLevel(Log.INFO);
        DB.me().insert(log);
        response.sendRedirect("QuanLyUser.jsp");
    }
}
