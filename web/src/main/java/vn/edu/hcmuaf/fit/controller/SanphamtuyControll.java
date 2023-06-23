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

@WebServlet(name = "sanphamtuychon", value = "/sanphamtuychon")
public class SanphamtuyControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        StoreService s = new StoreService();
        SoluongService sl = new SoluongService();
        List<products> listp = s.getListProductALL();
        List<Soluongbanra> listsl = sl.getTotalByProductTypeChooseDay(ngayBatDau,ngayKetThuc);
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
        request.getRequestDispatcher("Baocaosanphamtuychon.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

