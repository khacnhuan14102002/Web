package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.db.DB;
import vn.edu.hcmuaf.fit.service.CatalogService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCatalog", value = "/addCatalog")
public class AddCatalog extends HttpServlet {
    String name = "AUTH";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf8");
        String cid = request.getParameter("id");
        String cname = request.getParameter("name");


        category cate = new category();
        cate.setIdCat(cid);
        cate.setNameCat(cname);
        CatalogService.addCatalog(cate);
        Log log = new Log(Log.INFO, -1, this.name, "", 0);
        log.setSrc(this.name + "ADD CATEGORY SUCCESS");
        log.setContent("ADD CATEGORY SUCCESS:- " + cname);
        log.setLevel(Log.INFO);
        DB.me().insert(log);
        System.out.println(cate);
        response.sendRedirect("/managerCatalogControl");
    }
}
