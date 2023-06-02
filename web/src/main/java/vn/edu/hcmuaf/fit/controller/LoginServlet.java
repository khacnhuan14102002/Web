package vn.edu.hcmuaf.fit.controller;

import java.io.IOException;

import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.db.DB;

@WebServlet(value = {"/login"})
public class LoginServlet extends HttpServlet {
	String name = "AUTH";
	private UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String path = req.getServletPath();
		System.out.println("=== path: " + path);
		RequestDispatcher rd = null;
		switch (path) {
			case "":
				rd = req.getRequestDispatcher("/index.jsp");
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
		if (u != null) {
			HttpSession session = req.getSession();
			User user = userDao.findUserByMaUser(u.getIdUser());
			session.setAttribute("user", user);
			resp.sendRedirect(req.getContextPath() + "/index");
		} else {
			req.setAttribute("errorlogin", "tai khoan hoac mat khau khong dung");
			RequestDispatcher rd = req.getRequestDispatcher("" +
					"/login.jsp");
			rd.forward(req, resp);
		}

//		moi them log user
		Log log = new Log(Log.INFO, -1, this.name, "", 0);

		if (email == null || !checkLogin(email, pass)) {
//            req.getWriter().println("User Login flase");
			log.setSrc(this.name + "LOGIN FALSE");
			log.setContent("LOGIN FALSE:- " + email);
			log.setLevel(Log.WARNING);

		} else {
			resp.getWriter().println("User scess");
			log.setSrc(this.name + "LOGIN");
			log.setContent("LOGIN SECCESS: Email - " + email);
		}
		DB.me().insert(log);
	}


//}

	private boolean checkLogin(String email, String pass) {
		return false;
	}
}
