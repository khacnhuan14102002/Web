package vn.edu.hcmuaf.fit.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.edu.hcmuaf.fit.bean.Soluongbanra;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.SoluongService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "xuathoadontuychon", value = "/xuathoadontuychon")
public class XuathoadontuychonControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        StoreService s = new StoreService();
        SoluongService sl = new SoluongService();
        List<products> listp = s.getListProductALL();
        List<Soluongbanra> listsl = sl.getTotalByProductTypeChooseDay(ngayBatDau,ngayKetThuc);
        FileOutputStream file=new FileOutputStream("D:\\Hoadon\\"+"ngayBatDau"+"ngayKetThuc"+"hoaDon.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet workSheet=workbook.createSheet("1");
        XSSFRow row;

        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3,cell4,cell5;

        row=workSheet.createRow(0);
        cell0=row.createCell(0);
        cell0.setCellValue("Mã Sản Phẩm");
        cell1=row.createCell(1);
        cell1.setCellValue("Tên sản phẩm");
        cell2= row.createCell(2);
        cell2.setCellValue("Số lượng bán");
        cell3 = row.createCell(3);
        cell3.setCellValue("Doanh thu");



        double tongGia;
        int i=0;

        for (Soluongbanra sl1 : listsl) {i=i+1;
            for (products p : listp) {
                if (sl1.getProductID() == p.getIdProduct()) {
                    row=workSheet.createRow(i);
                    cell0=row.createCell(0);
                    cell0.setCellValue(sl1.getProductID());
                    cell1=row.createCell(1);
                    cell1.setCellValue(p.getNameProduct());
                    cell2= row.createCell(2);
                    cell2.setCellValue(sl1.getSoLuongDaBan());
                    cell3=row.createCell(3);
                    cell3.setCellValue(sl1.getSoLuongDaBan()*p.getPriceNew());

                }
            }
        }
        workbook.write(file);
        workbook.close();
        file.close();

        request.setAttribute("mess", "Đã xuất file Excel thành công!");
        request.getRequestDispatcher("/doanhsosanpham").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
