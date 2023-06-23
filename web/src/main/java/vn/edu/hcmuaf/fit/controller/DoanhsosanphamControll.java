package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Soluongbanra;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.SoluongService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "doanhsosanpham", value = "/doanhsosanpham")
public class DoanhsosanphamControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreService s = new StoreService();
        SoluongService sl = new SoluongService();
        List<products> listp = s.getListProductALL();
        List<Soluongbanra> listsl = sl.getSoluongbanra();
        double total=0;
        for (Soluongbanra sl1 : listsl) {
            for (products p : listp) {
                if (sl1.getProductID() == p.getIdProduct()) {

                    total += sl1.getSoLuongDaBan() * p.getPriceNew();
                }
            }
        }
        request.setAttribute("sum",total);
        request.setAttribute("listpro",listp);
        request.setAttribute("listsl",listsl);
        request.getRequestDispatcher("Baocaosanpham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

