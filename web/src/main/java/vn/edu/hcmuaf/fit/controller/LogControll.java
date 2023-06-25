package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.Soluongbanra;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.LogService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "log", value = "/log")
public class LogControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogService lo = new LogService();
        List<Log> list = lo.getAllLg();

        String indexPage = request.getParameter("page");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = list.size();
        int endPage = count / 12;
        if (count % 12 != 0) {
            endPage++;
        }
        List<Log> list_page = lo.paging(index);
        int totals=0;
        int totalf=0;
        for (Log l : list) {
                if(l.getSrc().equals("AUTHLOGIN")){
                    totals +=  1;
                }else{
                    totalf +=  1;
                }
            }
        request.setAttribute("endP", endPage);
        request.setAttribute("tag", index);
        request.setAttribute("list", list_page);
        request.setAttribute("totals",totals);
        request.setAttribute("totalf",totalf);
        request.getRequestDispatcher("Log.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
