package excelhandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aundre.Jess on 15-Oct-16.
 */

public class ExcelKeywordReader {

    public void executeKeywords(ExcelHandler excelSheet, KeywordExecutorUtility exeKey, String excelTestSheet, String className) {
        excelSheet.openSheet(System.getProperty("user.dir") + "//TestSheets//" + excelTestSheet);
        for (int row = 1; row < excelSheet.getRowCount(); row++) {
            List<Object> myParamList = new ArrayList<Object>();
            String methodName = excelSheet.getValueFromCell(0, row);
            for (int col = 1; col < excelSheet.getColumnCount(); col++) {
                if (!excelSheet.getValueFromCell(col, row).isEmpty()
                        & !excelSheet.getValueFromCell(col, row).equals("null")) {
                    myParamList.add(excelSheet.getValueFromCell(col, row));
                }
            }

            Object[] paramListObject = new String[myParamList.size()];
            paramListObject = myParamList.toArray(paramListObject);

            exeKey.runReflectionMethod(className, methodName, paramListObject);
        }
    }
}
