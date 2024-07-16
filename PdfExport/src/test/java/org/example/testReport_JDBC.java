package org.example;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName org.example.testReport_JDBC
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/10 16:22
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/10 16:22
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */

public class testReport_JDBC {
    @Test
    public void testReport_JDBC() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",
                        "root",
                        "123456");

        String jrxmlPath = "E:\\Parent\\PdfExport\\src\\main\\resources\\test1.jrxml";
        String jasperPath = "E:\\Parent\\PdfExport\\src\\main\\resources\\test1.jasper";

//编译模板
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);
//构造数据
        Map paramters = new HashMap();
        paramters.put("company", "优乐平台");

//填充数据---使用JDBC数据源方式填充
        JasperPrint jasperPrint =
                JasperFillManager.fillReport(jasperPath,
                        paramters, connection);
//输出文件
        String pdfPath = "D:\\test.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
    }
}
