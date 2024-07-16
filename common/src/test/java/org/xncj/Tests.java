package org.xncj;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Tests
 * @Description: 类描述
 * @Author: liangxiaoqiang
 * @CreateDate: 2024/7/13 8:14
 * @UpdateUser: 更新人
 * @UpdateDate: 2024/7/13 8:14
 * @UpdateRemark: 更新的信息
 * @Version: 1.0
 */

public class Tests {
    // 测试读取Excel文件
//    @org.junit.Tests
    public void test() throws IOException {
        // 创建工作簿对象并读取Excel文件
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\test.xlsx");
        // 获取第一个工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        // 遍历工作表中的每一行
        for (Row row : sheet) {
            // 遍历行中的每一个单元格
            for (Cell cell : row) {
                // 获取单元格的字符串值并打印
                String stringCellValue = cell.getStringCellValue();
                System.out.println(stringCellValue);
            }
        }
        // 关流
        workbook.close();
    }

    // 测试创建Excel文件
//    @org.junit.Tests
    public void test1() throws IOException {
        // 创建一个新的工作簿对象
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个名为"sheet1"的工作表
        XSSFSheet sheet = workbook.createSheet("sheet1");
        // 创建第一行并设置单元格值
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("名称");
        row.createCell(2).setCellValue("年龄");
        // 创建第二行并设置单元格值
        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("张三");
        row1.createCell(2).setCellValue("20");
        // 创建文件输出流并写入Excel文件
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.xlsx");
        workbook.write(fileOutputStream);

        // 刷新并关闭文件输出流
        fileOutputStream.flush();
        workbook.close();
        fileOutputStream.close();
    }




    @Test
    public void test2(){
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String s = iterator.next();
//            if (s.equals("3")){
//                iterator.remove();
//            }
//        }
//
//        System.out.println(list);
//        HashSet<Object> hashSet = new HashSet<>();
//        for (int i = 1; i <= 11*10000; i++) {
//            int code = new Object().hashCode();
//            if(!hashSet.contains(code)){
//                hashSet.add(code);
//            }else{
//                System.out.println("发生了hash冲突在第"+i+"次 值是："+code);
//            }
//        }
//        System.out.println(hashSet.size());

        List<Integer> list = Arrays.asList(1,1,2,3,4,4,5,6);
        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);
        list1.forEach(num ->{
            if(list2.indexOf(num) != list2.lastIndexOf(num)){
                list2.remove(list2.lastIndexOf(num));
            }
        });
        new HashSet<>(list2).stream().filter(num-> num > 1).collect(Collectors.toList());
        System.out.println(list2);
    }

    @Test
    public void test3(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 17; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
    @Test
    public void test4(){
        int num=sum(1,2);
    }

    public int sum(int a,int b){
        return a+b;
    }
}

