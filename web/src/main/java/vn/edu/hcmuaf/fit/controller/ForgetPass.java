package vn.edu.hcmuaf.fit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.service.MailService;

@WebServlet(value = {"/forget"})
public class ForgetPass extends HttpServlet{

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf8");
        RequestDispatcher rd = req.getRequestDispatcher("/quenmatkhau.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf8");
        String email = req.getParameter("email");
        String pass = MailService.randomPassword();
        userDao.updatePassword(pass, email);
        Thread run = new Thread(new Runnable() {
            public void run() {
                new MailService().sendMail(email,
                        "mat khau moi cua ban la: "+pass);
            }
        });
        run.start();
        resp.sendRedirect(req.getContextPath() + "/login");
    }

}
