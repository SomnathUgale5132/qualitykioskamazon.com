package utility;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
	XSSFWorkbook workbook;
    XSSFSheet sheet;

    // Method to write product details into Excel file
    @SuppressWarnings("resource")
	public static void writeProductDetailsToExcel(String filePath, int productIndex, String[] productDetails) throws IOException, InvalidFormatException {
        File file = new File(filePath);

        // Create a workbook and sheet if the file doesn't exist
        XSSFWorkbook workbook;
        XSSFSheet sheet;

        // Use try-with-resources to ensure proper closing of resources
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            if (file.exists()) {
                workbook = new XSSFWorkbook(file);
                sheet = workbook.getSheetAt(0);  // Get the first sheet
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Product Details");
                // Create headers if the file is new
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Index");
                headerRow.createCell(1).setCellValue("Product Title");
                headerRow.createCell(2).setCellValue("Product Price");
            }

            // Create a new row for the product data
            int rowCount = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(rowCount);

            // Write the product index and details
            row.createCell(0).setCellValue(productIndex);
            row.createCell(1).setCellValue(productDetails[0]);
            row.createCell(2).setCellValue(productDetails[1]);

            // Write the data to the file
            workbook.write(fileOut);
        } catch (IOException | InvalidFormatException e) {
            // Handle any errors that may occur during the file writing process
            System.err.println("Error writing to the Excel file: " + e.getMessage());
            throw e;
        }
    }
}