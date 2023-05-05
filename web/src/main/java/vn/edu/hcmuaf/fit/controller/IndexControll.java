package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Soluongbanra;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;
import vn.edu.hcmuaf.fit.service.SoluongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "index", value = "/index")
public class IndexControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
