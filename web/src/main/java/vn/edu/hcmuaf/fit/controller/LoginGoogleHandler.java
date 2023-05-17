package vn.edu.hcmuaf.fit.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import vn.edu.hcmuaf.fit.bean.Constants;
import vn.edu.hcmuaf.fit.bean.GoogleUtils;
import vn.edu.hcmuaf.fit.service.UserGoogleDto;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginGoogleHandler", value = "/LoginGoogleHandler")
//@WebServlet(urlPatterns = { "/LoginGoogleHandler" })
public class LoginGoogleHandler extends HttpServlet {

        private static final long serialVersionUID = 1L;
        public LoginGoogleHandler() {
            super();
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String code = request.getParameter("code");
            if (code == null || code.isEmpty()) {
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
                dis.forward(request, response);
            } else {
                String accessToken = GoogleUtils.getToken(code);
                UserGoogleDto googlePojo = GoogleUtils.getUserInfo(accessToken);
                request.setAttribute("id", googlePojo.getId());
                request.setAttribute("name", googlePojo.getName());
                request.setAttribute("email", googlePojo.getEmail());
                RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                dis.forward(request, response);
            }
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
}