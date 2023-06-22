package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.db.DB;
import vn.edu.hcmuaf.fit.service.CatalogService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditCatalog", value = "/editCatalog")
public class EditCatalog extends HttpServlet {
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

        category cat = new category();
        cat.setIdCat(cid);
        cat.setNameCat(cname);
        Log log = new Log(Log.INFO, -1, this.name, "", 0);
        log.setSrc(this.name + "Edit categoly sussec");
        log.setContent("Edit categoly sussec:- " + cname);
        log.setLevel(Log.INFO);
        DB.me().insert(log);
        System.out.println(cat);
        CatalogService.updateCatalog(cat);
        response.sendRedirect("/managerCatalogControl");
    }
}
