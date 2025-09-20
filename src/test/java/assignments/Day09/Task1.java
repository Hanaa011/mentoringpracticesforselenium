package assignments.Day09;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Task1 extends TestBase2 {

    @Test
    void exportTableToExcel() throws IOException {
        // 1- Go to the webpage
        driver.get("https://claruswaysda.github.io/webTable.html");

        // 2- Locate the table
        WebElement table = driver.findElement(By.id("t1"));

        // 3- Get all rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // 4- Create a new Excel workbook & sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("t1");

        // 5- Loop through rows & columns
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));


            if (cols.isEmpty()) {
                cols = rows.get(i).findElements(By.tagName("th"));
            }

            for (int j = 0; j < cols.size(); j++) {
                Cell cell = excelRow.createCell(j);
                cell.setCellValue(cols.get(j).getText());
            }
        }

        // 6- Save to file
        String filePath = "Table1.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Table exported to Excel successfully: " + filePath);
    }
}
