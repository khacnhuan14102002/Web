package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.product;
import vn.edu.hcmuaf.fit.service.ManagerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditProduct", value = "/editProduct")
public class EditProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf8");

        String pid = request.getParameter("id");
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        String pprice_1 = request.getParameter("price_1");
        String pprice_2 = request.getParameter("price_2");
        String pdescription = request.getParameter("description");

        product product = new product();
        product.setMasp(pid);
        product.setTensp(pname);
        product.setHinhanh(pimage);
        product.setGiamoi(Integer.parseInt(pprice_1));
        product.setGiacu(Integer.parseInt(pprice_2));
        product.setMota(pdescription);
        System.out.println(product);
        ManagerService.updateProduct(product);
        response.sendRedirect("/web_war/ManageControl");
    }
}
