package vn.edu.hcmuaf.fit.controller;

import com.google.protobuf.Internal;
import vn.edu.hcmuaf.fit.bean.*;
import vn.edu.hcmuaf.fit.service.ProductService;
import vn.edu.hcmuaf.fit.service.SoluongService;
import vn.edu.hcmuaf.fit.service.StoreService;
import vn.edu.hcmuaf.fit.service.WishListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Storecontrol", value = "/store")
public class Storecontrol extends HttpServlet {
    public Storecontrol() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreService pro = new StoreService();
        String indexPage = request.getParameter("page");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = pro.gettotalpro();
        int endPage = count / 12;
        if (count % 12 != 0) {
            endPage++;
        }
        List<products> listP = pro.paging(index);
        List<products> listAllProduct = ProductService.getListProductALL();
        List<Soluongbanra> listTop10Product = SoluongService.get10Soluongbanra();
        WishListService service = new WishListService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int sizeW = 0;
        if (user != null) {
            ArrayList<Wishlist> list = service.getAllWish(user.getIdUser());
            sizeW = list.size();
        }
        List<category> listC = pro.getListCat();

        request.setAttribute("listAllProduct", listAllProduct);
        request.setAttribute("listTop10Product", listTop10Product);

        request.setAttribute("endP", endPage);
        request.setAttribute("tag", index);
        request.setAttribute("listCC", listC);
        request.setAttribute("listP", listP);
        request.setAttribute("sizeW", sizeW);


        request.getRequestDispatcher("store.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public static void main(String[] args) {


        }

}
