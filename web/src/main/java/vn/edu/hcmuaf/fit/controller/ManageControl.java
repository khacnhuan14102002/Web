package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Loai;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageControl", value = "/ManageControl")
public class ManageControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ManagerService mana = new ManagerService();
        List<products> list = mana.getAllProduct();
        List<Loai> listC = mana.getAllCategory();

        request.setAttribute("listC", listC);
        request.setAttribute("listP", list);
        request.getRequestDispatcher("managerProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
