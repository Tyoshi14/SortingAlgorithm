package inputAndOutput;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OutputExcel {

	public boolean outputFile(ArrayList<ArrayList<String>> dataItems,String fileName) {
		try {
			Workbook wkbk;
			if (fileName.endsWith(".xls")) {
				wkbk = new HSSFWorkbook();
			} else {
				wkbk = new XSSFWorkbook();
			}
			Sheet sheet = wkbk.createSheet();


			// Ð´³öÄÚÈÝ
			for (int i = 0; i < dataItems.size(); i++) {

				ArrayList<String> oneRowList = dataItems.get(i);
				Row row = sheet.createRow(i);
				for (int j = 0; j < oneRowList.size(); j++) {
					
					Cell cell = row.createCell(j);
					cell.setCellValue(oneRowList.get(j));
				}
			}
			FileOutputStream ost = new FileOutputStream(fileName);
			wkbk.write(ost);
			ost.flush();
			ost.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	
}
