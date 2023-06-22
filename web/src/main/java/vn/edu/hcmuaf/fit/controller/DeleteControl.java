package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.DB;
import vn.edu.hcmuaf.fit.service.ManagerService;
import vn.edu.hcmuaf.fit.service.ProductService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteControl", value = "/delete")
public class DeleteControl extends HttpServlet {
    String name = "AUTH";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        ProductService p = new ProductService();
        products r = p.getprobyId(pid);
        ManagerService mana = new ManagerService();
        mana.removeProduct(pid);
        Log log = new Log(Log.INFO, -1, this.name, "", 0);
        log.setSrc(this.name + "Edit product sussec");
        log.setContent("Edit product sussec:- " + r.getNameProduct());
        log.setLevel(Log.INFO);
        DB.me().insert(log);
        response.sendRedirect("/manageControl");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
