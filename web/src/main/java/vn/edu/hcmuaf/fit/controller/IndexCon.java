package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Loai;
import vn.edu.hcmuaf.fit.service.LoaiService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IndexControl", value = "/IndexControl")
public class IndexCon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoaiService ls = new LoaiService();
        ArrayList<Loai> listL = ls.getLoai();
        request.setAttribute("listL", listL);
       request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
