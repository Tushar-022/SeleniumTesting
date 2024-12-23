package com.example.tests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SelectStudentsWithHighMarks {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("students.xlsx"));
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Start from row 1, assuming row 0 is the header
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                boolean hasHighMarks = false;

                // Loop through the marks columns (assuming columns 2-5 contain the marks)
                for (int i = 2; i <= 5; i++) {
                    Cell cell = row.getCell(i);

                    // Check the cell type and handle accordingly
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            double marks = cell.getNumericCellValue();
                            if (marks > 60) {
                                hasHighMarks = true;
                                break; // No need to check further subjects
                            }
                        } else if (cell.getCellType() == CellType.STRING) {
                            // Handle string cells if necessary
                            System.out.println("Unexpected string value in a marks column: " + cell.getStringCellValue());
                        }
                    }
                }

                // If the student has marks > 60 in any subject, print their name
                if (hasHighMarks) {
                    Cell nameCell = row.getCell(1); // Assuming Name is in column 1
                    if (nameCell != null && nameCell.getCellType() == CellType.STRING) {
                        System.out.println("Student with high marks: " + nameCell.getStringCellValue());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

