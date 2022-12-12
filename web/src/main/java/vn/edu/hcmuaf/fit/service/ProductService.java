package vn.edu.hcmuaf.fit.service;

import org.jdbi.v3.core.Handle;
import vn.edu.hcmuaf.fit.bean.product;
import vn.edu.hcmuaf.fit.db.JDBiConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    public static List<product> getListProduct(){
       return  JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from sanpham").mapToBean(product.class).stream().collect(Collectors.toList());
        });

    }

}
