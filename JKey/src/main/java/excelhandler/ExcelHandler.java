package excelhandler;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandler {

    Workbook wbWorkbook;
    Sheet shSheet;

    public void openSheet(String filePath) {
        FileInputStream fs;
        try {
            fs = new FileInputStream(filePath);
            wbWorkbook = Workbook.getWorkbook(fs);
            shSheet = wbWorkbook.getSheet(0);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValueFromCell(int iColNumber, int iRowNumber) {
        return shSheet.getCell(iColNumber, iRowNumber).getContents();
    }

    public int getRowCount() {
        return shSheet.getRows();
    }

    public int getColumnCount() {
        return shSheet.getColumns();
    }
}
