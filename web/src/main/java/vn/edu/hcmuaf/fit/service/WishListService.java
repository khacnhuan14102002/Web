package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.Wishlist;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.db.JDBiConnector;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WishListService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public void adddwish(int idpro,String img,String name,int price,int idU){
        String query = "INSERT INTO Wishlist (IdPro,Image,NamePro, PriceNew,IdU) VALUES (?,?,?,?,?)";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1,idpro);
            ps.setString(2,img);
            ps.setString(3, name);
            ps.setInt(4, price);
            ps.setInt(5,idU);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }
    public ArrayList<Wishlist> getAllWish(int idU){
        ArrayList<Wishlist> list = new ArrayList<>();
        String query="select * from wishlist where IdU = ?";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,idU);
            rs=ps.executeQuery();
            while(rs.next()){
                Wishlist wish = new Wishlist(rs.getInt("IdPro"),
                        rs.getString("Image"),
                        rs.getString("NamePro"),
                        rs.getInt("PriceNew"),
                        rs.getInt("IdU"));
                list.add(wish);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
        return list;
    }
    public void deleteWishbyIdPro(int idPro) {
        String query = "delete from wishlist where IdPro = ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,idPro);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {

        WishListService w = new WishListService();
       // System.out.println(w.getAllWish(3));
        w.deleteWishbyIdPro(2);

    }

}
