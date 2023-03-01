package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.products;

import java.util.ArrayList;

public class Cart {
    public static ArrayList<products> dssanpham = new ArrayList<>();
    public static ArrayList<products> giohang = new ArrayList<>();

    public boolean addCart(String masp){
        for(int i =0; i <dssanpham.size();i++){
            if(dssanpham.get(i).getIdProduct().equals(masp)){
                giohang.add(dssanpham.get(i));
                return true;
            }
        }
        return false;
    }

    public static ArrayList<products> getGiohang() {
        return giohang;
    }
}
