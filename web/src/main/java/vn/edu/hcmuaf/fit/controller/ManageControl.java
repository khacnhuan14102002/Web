package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ManagerService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageControl", value = "/manageControl")
public class ManageControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ManagerService mana1 = new ManagerService();
        StoreService mana = new StoreService();
        String indexPage = request.getParameter("page");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = mana.gettotalpro();
        int endPage = count / 12;
        if (count % 12 != 0) {
            endPage++;
        }
        List<products> list_page = mana.paging(index);
        List<products> listP = mana1.getAllProduct();
        List<category> listC = mana1.getAllCategory();
        request.setAttribute("tag", index);
        request.setAttribute("endP", endPage);
        request.setAttribute("listC", listC);
//        request.setAttribute("listP", listP);
        request.setAttribute("listP", list_page);
        request.getRequestDispatcher("managerProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
