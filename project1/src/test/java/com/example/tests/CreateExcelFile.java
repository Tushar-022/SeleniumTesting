package com.example.tests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelFile {
    public static void main(String[] args) {
        // Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a sheet
        XSSFSheet sheet = workbook.createSheet("Students_TK");

        // Define header row
        String[] headers = {"Student ID", "Name", "Math", "Science", "English", "History", "Total Marks", "Result"};
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Add sample student data
        Object[][] studentData = {
            {1, "John", 58, 65, 72, 80},
            {2, "Alice", 90, 87, 78, 92},
            {3, "Bob", 45, 67, 55, 64},
            {4, "Charlie", 71, 60, 66, 80},
            {5, "David", 52, 50, 62, 56},
            {6, "Emma", 88, 92, 94, 79},
            {7, "Frank", 60, 61, 59, 65},
            {8, "Grace", 70, 72, 80, 69},
            {9, "Hannah", 58, 55, 50, 61},
            {10, "Ivy", 84, 79, 73, 66}
        };

        int rowNum = 1;
        for (Object[] student : studentData) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < student.length; i++) {
                Cell cell = row.createCell(i);
                if (student[i] instanceof String) {
                    cell.setCellValue((String) student[i]);
                } else if (student[i] instanceof Integer) {
                    cell.setCellValue((Integer) student[i]);
                }
            }
        }

        // Write to file
        try (FileOutputStream fos = new FileOutputStream("students.xlsx")) {
            workbook.write(fos);
            System.out.println("Excel file created: students.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

