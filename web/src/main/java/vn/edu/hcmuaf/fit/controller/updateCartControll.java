package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.ProductCart;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "updateCart", value = "/updateCart")
public class updateCartControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quan = Integer.parseInt(request.getParameter("quantity"));
        int id = Integer.parseInt(request.getParameter("idprocart"));
    System.out.println(id);
    System.out.println(quan);
    HttpSession session = request.getSession();
    products pro = ProductService.getprobyId(id);
        ProductCart procart;
        HashMap<Integer,ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if(cart == null){
            cart = new HashMap<Integer,ProductCart>();
            procart = new ProductCart(quan,pro);
            cart.put(id,procart);
        }else{
            if(cart.containsKey(id)){
                if(quan == 0){
                    cart.remove(id);
                }else{
                    procart = cart.get(id);
                    procart.setQuantity(quan);
                }
            }else{
                procart = new ProductCart(quan,pro);
                cart.put(id,procart);
            }
        }
        session.setAttribute("cart",cart);
        response.sendRedirect("/cart");
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
