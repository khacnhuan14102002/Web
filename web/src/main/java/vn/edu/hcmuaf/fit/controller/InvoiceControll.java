package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.ProductCart;
import vn.edu.hcmuaf.fit.bean.Soluongbanra;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.bean.Wishlist;
import vn.edu.hcmuaf.fit.service.SoluongService;
import vn.edu.hcmuaf.fit.service.WishListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "invoice", value = "/invoice")
public class InvoiceControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SoluongService sls = new SoluongService();
        WishListService service = new WishListService();
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        int price = 0;
        for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
            Integer key = entry.getKey();
            ProductCart productcart = entry.getValue();
            price += productcart.quantity * productcart.pro.getPriceNew();

            Soluongbanra sl =sls.checkSoLuongDaBanExist(entry.getValue().pro.getIdProduct());

            if(sl==null){
                sls.insertSoLuongDaBan(productcart.pro.getIdProduct(),productcart.quantity);
            }else{
                int sl1 =0;
                sl1 +=productcart.quantity +sl.getSoLuongDaBan() ;

                sls.updateSoluong(new Soluongbanra(productcart.pro.getIdProduct(),sl1));
            }

        }

        User user = (User) session.getAttribute("user");
        ArrayList<Wishlist> list =service.getAllWish(user.getIdUser());
        int sizeW= list.size();
        request.setAttribute("sizeW",sizeW);
        session.setAttribute("total", price);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
