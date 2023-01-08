package vn.edu.hcmuaf.fit.bean;

import java.util.TreeMap;

public class Giohang {
    public Giohang(TreeMap<products, Integer> list, long cartid) {
        this.list = list;
        this.cartid = cartid;
    }

    public Giohang() {
        list= new TreeMap<>();
        cartid = System.currentTimeMillis();
    }

    private TreeMap<products,Integer> list;
    private long  cartid;

    public TreeMap<products, Integer> getList() {
        return list;
    }

    public void setList(TreeMap<products, Integer> list) {
        this.list = list;
    }

    public long getCartid() {
        return cartid;
    }

    public void setCartid(long cartid) {
        this.cartid = cartid;
    }
    public void insertcart(products pro,int soluong){
        boolean bln= list.containsKey(pro);
        if(bln){
            int sl=list.get(pro);
            soluong += sl;
            list.put(pro,soluong);
        }else{
            list.put(pro,soluong);
        }
    }
}
