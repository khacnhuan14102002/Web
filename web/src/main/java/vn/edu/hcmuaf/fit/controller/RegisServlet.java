package vn.edu.hcmuaf.fit.controller;

import java.io.IOException;
import java.sql.Date;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.service.MailService;

@WebServlet(value = { "/regis", "/successRegis" })
public class RegisServlet extends HttpServlet {

	private UserDao userDao = new UserDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String path = req.getServletPath();
		System.out.println("=== path: " + path);
		RequestDispatcher rd = null;
		switch (path) {
			case "/regis":
				rd = req.getRequestDispatcher("/regis.jsp");
				break;
			case "/successRegis":
				String key = req.getParameter("key");
				if (key != null) {
					userDao.activeByActivationKey(key);
					req.setAttribute("mess", "dang ky thanh cong, hay dang nhap");
					rd = req.getRequestDispatcher("/login.jsp");
				}
				rd = req.getRequestDispatcher("/login.jsp");
				break;
			default:
				break;
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String activationKey = MailService.randomKey();
		String ten = req.getParameter("fullname");
		String email = req.getParameter("email");
		String sdt = req.getParameter("sodt");
		String pass = req.getParameter("pass");

		Thread run = new Thread(new Runnable() {
			public void run() {
				new MailService().sendMail(email,
						"nhap vao link sau de kich hoat tai khoan: http://localhost:8080/project/successRegis?key="
								+ activationKey);
			}
		});
		run.start();

		User u = new User();
		u.setKeyactive(activationKey);
		u.setActive(0);
		u.setEmailUs(email);
		u.setRoleUs(0);
		u.setRegistrationDate(new Date(System.currentTimeMillis()));
		u.setPass(pass);
		u.setPhone(sdt);
		u.setNameUser(ten);
		userDao.saveUser(u);
		resp.sendRedirect(req.getContextPath() + "/login");
	}

	public static void main(String[] args) {

	}

}
