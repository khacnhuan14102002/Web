package vn.edu.hcmuaf.fit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.bean.User;

@WebServlet(value = { "/user" })
public class UserController extends HttpServlet{

	private UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/success.jsp");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		req.setAttribute("user", user);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ten = req.getParameter("fullname");
		String email = req.getParameter("email");
		String sdt = req.getParameter("sdt");
		String pass = req.getParameter("pass");

		User u = new User();
		u.setNameUser(ten);
		u.setEmailUs(email);
		u.setPhone(sdt);
		u.setPass(pass);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		u.setIdUser(user.getIdUser());
		userDao.updateUser(u);
		User us = userDao.findUserByMaUser(user.getIdUser());
		session.setAttribute("user", us);
		resp.sendRedirect(req.getContextPath() + "/user");
	}
}
