package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.products;
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

      int pid = Integer.parseInt(request.getParameter("id"));
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        String pprice_new = request.getParameter("price_new");
        String pprice_old = request.getParameter("price_old");
        String pdescription = request.getParameter("description");

        products product = new products();
        product.setIdProduct(pid);
        product.setNameProduct(pname);
        product.setImage(pimage);
        product.setPriceNew(Integer.parseInt(pprice_new));
        product.setPriceOld(Integer.parseInt(pprice_old));
        product.setDescription(pdescription);
        System.out.println(product);
        ManagerService.updateProduct(product);
        response.sendRedirect("/manageControl");
    }
}
