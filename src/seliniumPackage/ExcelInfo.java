package seliniumPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInfo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\SUNNY\\eclipse-workspace\\Introduction\\fruitPrices.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(fis);
		XSSFSheet sheet=getSheet(workBook, "Sheet1");
		int appleColumnNumber=getColumnNumber(sheet, "Apple");
		System.out.println(appleColumnNumber);

	}

	public static XSSFSheet getSheet(XSSFWorkbook workBook,String sheetName) {
		int totalSheets=workBook.getNumberOfSheets();
		XSSFSheet sheet = null;
		for(int i=0;i<totalSheets;i++) {
			if(workBook.getSheetName(i).equalsIgnoreCase(sheetName)){
				sheet=workBook.getSheetAt(i);
			}
		}
		return sheet;
	}
	public static Integer getColumnNumber(XSSFSheet sheet,int rowNumber,String columnValue) {
		DataFormatter dataFormatter = new DataFormatter();
		
		
		Row row = null;
		Iterator<Row> rowPointer= sheet.iterator();
		for(int i=0;i<sheet.getLastRowNum();i++) {
			row=rowPointer.next();
			if(i==rowNumber) 
				break;
		}
		
		
		Iterator<Cell> cellPointer=row.cellIterator();
		int k=0;Integer column = null;
		while(cellPointer.hasNext()) {
			Cell cell=cellPointer.next();
			if(cell.getCellType()==CellType.STRING &&  cell.getStringCellValue().equalsIgnoreCase(columnValue)) {
				column=k;
				
			}
			else if(cell.getCellType()==CellType.NUMERIC) {
				String formattedCellStr = dataFormatter.formatCellValue(cell);
				if(formattedCellStr.equalsIgnoreCase(columnValue)) {
					column=k;
				}
			}
			k++;
		}
		return column;
		
	}
	
	public static Integer getRowNumber(XSSFSheet sheet,int columnNumber,String rowValue) {
		DataFormatter dataFormatter = new DataFormatter();
		Integer rowNumber=null;
		Iterator<Row> rowPointer=sheet.iterator();
		int k=0;
		while(rowPointer.hasNext()) {
			Row row=rowPointer.next();
			Cell cell=row.getCell(columnNumber);
			if(cell.getCellType()==CellType.STRING && cell.getStringCellValue().equals(rowValue)) {
				rowNumber=k;
			}
			else if(cell.getCellType()==CellType.NUMERIC) {
				String formattedCellStr = dataFormatter.formatCellValue(cell);
				if(formattedCellStr.equals(rowValue)) {
					rowNumber=k;
				}
			}
			k++;
		}
		return rowNumber;
	}
	public static Integer getRowNumber(XSSFSheet sheet,String text) {
		DataFormatter dataFormatter = new DataFormatter();
		Integer rowNumber=null;
		Integer columnNumber=null;
		Iterator<Row> rowPointer=sheet.iterator();
		int r=0;
		while(rowPointer.hasNext()) {
			int c=0;
			Row row=rowPointer.next();
			Iterator<Cell> cellPointer=row.cellIterator();
			while(cellPointer.hasNext()) {
				
				Cell cell=cellPointer.next();
				if(cell.getCellType()==CellType.STRING && cell.getStringCellValue().equals(text)) {
					columnNumber=c;
					rowNumber=r;
					break;
				}
				else if(cell.getCellType()==CellType.NUMERIC) {
					String formattedCellStr = dataFormatter.formatCellValue(cell);
					if(formattedCellStr.equals(text)) {
						columnNumber=c;
						rowNumber=r;
						break;
					}
				}
				c++;
			}
			r++;
		}
		return rowNumber;
	}
	
	public static Integer getColumnNumber(XSSFSheet sheet,String text) {
		DataFormatter dataFormatter = new DataFormatter();
		Integer rowNumber=null;
		Integer columnNumber=null;
		Iterator<Row> rowPointer=sheet.iterator();

		int r=0;
		while(rowPointer.hasNext()) {
			int c=0;
			Row row=rowPointer.next();
			Iterator<Cell> cellPointer=row.cellIterator();
			while(cellPointer.hasNext()) {
				
				Cell cell=cellPointer.next();
				if(cell.getCellType()==CellType.STRING && cell.getStringCellValue().equals(text)) {
					columnNumber=c;
					rowNumber=r;
					break;
				}
				else if(cell.getCellType()==CellType.NUMERIC) {
					String formattedCellStr = dataFormatter.formatCellValue(cell);
					if(formattedCellStr.equals(text)) {
						columnNumber=c;
						rowNumber=r;
						break;
					}
				}
				c++;
			}
			r++;
		}
		return columnNumber;
	}
	public static String getCellValue(XSSFSheet sheet, int rowNumber,int columnNumber) {
		DataFormatter dataFormatter = new DataFormatter();
		Row row=sheet.getRow(rowNumber);
		Cell cell=row.getCell(columnNumber);
		String cellValue = null;
		if(cell.getCellType()==CellType.STRING) {
			cellValue=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC) {
			cellValue = dataFormatter.formatCellValue(cell);
		}
		return cellValue;
		
	}
}
