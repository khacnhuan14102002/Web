package vn.edu.hcmuaf.fit.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.*;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.dao.UserDao;
import vn.edu.hcmuaf.fit.service.InvoiceService;

@WebServlet(name = "xuatexcelHoadon", value = "/xuatexcelHoadon")
public class XuatexcelHoadonControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String thangXuat = request.getParameter("dateHoaDons");
        String nam = request.getParameter("dateHoaDone");
        InvoiceService in = new InvoiceService();
       UserDao u = new UserDao();
      List<Invoice> list = in.getAllInbyMonth(thangXuat,nam);
        List<User> listAllAccount = u.getAllUsers();


        FileOutputStream file=new FileOutputStream("D:\\Hoadon\\"+thangXuat+nam+"hoaDon.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet workSheet=workbook.createSheet("1");
        XSSFRow row;

        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3,cell4,cell5;

        row=workSheet.createRow(0);
        cell0=row.createCell(0);
        cell0.setCellValue("Mã Hóa Đơn");
        cell1=row.createCell(1);
        cell1.setCellValue("Account");
        cell2= row.createCell(2);
        cell2.setCellValue("sdt");
        cell3 = row.createCell(3);
        cell3.setCellValue("Tên Account");
        cell4=row.createCell(4);
        cell4.setCellValue("Tổng Giá(VND)");
        cell5=row.createCell(5);
        cell5.setCellValue("Ngày Xuất");



        double tongGia;
        int i=0;

        for (Invoice o : list) {

            i=i+1;
            for (User a : listAllAccount) {
                if(o.getIdUs()==a.getIdUser()) {
                    tongGia=Math.round((o.getTotal()) * 100.0) / 100.0;
                    row=workSheet.createRow(i);
                    cell0=row.createCell(0);
                    cell0.setCellValue(o.getIdIn());
                    cell1=row.createCell(1);
                    cell1.setCellValue(a.getIdUser());
                    cell2= row.createCell(2);
                    cell2.setCellValue(o.getPhone());
                    cell3=row.createCell(3);
                    cell3.setCellValue(a.getNameUser());
                    cell4=row.createCell(4);
                    cell4.setCellValue(tongGia);
                    cell5=row.createCell(5);
                    cell5.setCellValue(thangXuat+'/'+nam);

                }
            }
        }
        workbook.write(file);
        workbook.close();
        file.close();

        request.setAttribute("mess", "Đã xuất file Excel thành công!");
        request.getRequestDispatcher("/managerOrder").forward(request, response);


//    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
