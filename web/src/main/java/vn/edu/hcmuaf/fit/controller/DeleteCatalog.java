package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.service.CatalogService;
import vn.edu.hcmuaf.fit.service.ManagerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCatalog", value = "/deleteCatalog")
public class DeleteCatalog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        CatalogService cata = new CatalogService();
        cata.removeCatalog(cid);
        response.sendRedirect("/managerCatalogControl");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
