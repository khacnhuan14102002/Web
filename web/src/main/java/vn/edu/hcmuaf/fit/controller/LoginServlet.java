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

@WebServlet(value = {"","/login"})
public class LoginServlet extends HttpServlet{

	private UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String path = req.getServletPath();
		System.out.println("=== path: " + path);
		RequestDispatcher rd = null;
		switch (path) {
		case "":
			rd = req.getRequestDispatcher("/login.jsp");
			break;
		case "/login":
			rd = req.getRequestDispatcher("/login.jsp");
			break;
		default:
			break;
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		User u = userDao.login(email, pass);
		if(u != null) {
			HttpSession session = req.getSession();
			User user = userDao.findUserByMaUser(u.getIdUser());
			session.setAttribute("user", user);
			resp.sendRedirect(req.getContextPath() + "/user");
		}
		else {
			req.setAttribute("errorlogin", "tai khoan hoac mat khau khong dung");
			RequestDispatcher rd = req.getRequestDispatcher("" +
					"/login.jsp");
			rd.forward(req, resp);
		}
	}

	
}
