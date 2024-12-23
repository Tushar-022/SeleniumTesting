package com.example.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdateExcelFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("students.xlsx"));
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Update total marks, result, and grade
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    double total = 0;
                    boolean isPass = true; // Assume the student passes initially
                    String grade = "E";   // Default grade

                    // Calculate total marks and determine grade
                    for (int j = 2; j <= 5; j++) { // Math to History columns
                        Cell cell = row.getCell(j);
                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                            double marks = cell.getNumericCellValue();
                            total += marks;

                            // Check if the student fails
                            if (marks < 40) {
                                isPass = false;
                            }

                            // Assign grade based on marks
                            if (marks > 80) {
                                grade = "A";
                            } else if (marks >= 60) {
                                grade = "B";
                            } else if (marks >= 50) {
                                grade = "C";
                            } else if (marks >= 40) {
                                grade = "D";
                            } else {
                                grade = "E";
                            }
                        }
                    }

                    // Update Total Marks column (index 6)
                    Cell totalMarksCell = row.createCell(6);
                    totalMarksCell.setCellValue(total);

                    // Update Result column (index 7)
                    Cell resultCell = row.createCell(7);
                    resultCell.setCellValue(isPass ? "Pass" : "Fail");

                    // Update Grade column (index 8)
                    Cell gradeCell = row.createCell(8);
                    gradeCell.setCellValue(grade);
                }
            }

            // Save updated file
            try (FileOutputStream fos = new FileOutputStream("updated_students.xlsx")) {
                workbook.write(fos);
                System.out.println("Updated Excel file created: updated_students.xlsx");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
