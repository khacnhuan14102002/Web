package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.service.LogService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "logtuychon", value = "/logtuychon")
public class LogchooseControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogService lo = new LogService();
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        List<Log> list = lo.getAllChoose(ngayBatDau,ngayKetThuc);
        request.setAttribute("list",list);
        int totals=0;
        int totalf=0;
        for (Log l : list) {
            if(l.getSrc().equals("AUTHLOGIN")){
                totals +=  1;
            }else{
                totalf +=  1;
            }
        }
        request.setAttribute("totals",totals);
        request.setAttribute("totalf",totalf);
        request.getRequestDispatcher("LogChoose.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}