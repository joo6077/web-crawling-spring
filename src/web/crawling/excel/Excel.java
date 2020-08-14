package web.crawling.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public FileOutputStream makeExcel(ArrayList<String> values) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("sheet");
		for (int i = 0; i < values.size(); i++) {
			XSSFRow row = sheet.createRow(i);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue(values.get(i));
		}
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("C:/Users/AORUS/Desktop/Project/sample.xlsx");
			workbook.write(fout);
			fout.close();
			System.out.println("파일 생성 완료!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fout;
		
	}
}
