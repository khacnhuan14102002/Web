package vn.edu.hcmuaf.fit.controller;

import com.google.protobuf.Internal;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Storecontrol", value = "/store")
public class Storecontrol extends HttpServlet {
    public Storecontrol() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreService pro = new StoreService();

        List<products> listP = pro.getListProductALL();

        List<category> listC = pro.getListCat();
        request.setAttribute("listCC",listC);
        request.setAttribute("listP",listP);



        request.getRequestDispatcher("store.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public static void main(String[] args) {

        List<products> listp = ProductService.getListProductALL();
        for(products o : listp){
            System.out.println(o);
        }
    }
}
