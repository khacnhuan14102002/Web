package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.db.DB;
import vn.edu.hcmuaf.fit.service.CatalogService;
import vn.edu.hcmuaf.fit.service.ManagerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCatalog", value = "/deleteCatalog")
public class DeleteCatalog extends HttpServlet {
    String name = "AUTH";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        CatalogService cata = new CatalogService();
        cata.removeCatalog(cid);
        Log log = new Log(Log.INFO, -1, this.name, "", 0);
        log.setSrc(this.name + "Delete categoly sussec");
        log.setContent("Delete categoly sussec:- " + cid);
        log.setLevel(Log.INFO);
        DB.me().insert(log);
        response.sendRedirect("/managerCatalogControl");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}