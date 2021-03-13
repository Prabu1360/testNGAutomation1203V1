package in.testNGautomation.in.testNGAutomation1203;

import java.io.IOException;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class readExcel_DataProvider 
	{
		static String filePath= System.getProperty("user.dir");
		static XSSFWorkbook workbook;
		public static void main(String[] args) throws IOException {
			rowCount();
	}
	
		public static void rowCount() throws IOException 
		{
			workbook = new XSSFWorkbook(filePath+"/Book1.xlsx");
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			int row= sheet.getPhysicalNumberOfRows();
			//System.out.println("the row count is "+row);
			
			for (int i = 1; i <row ; i++) 
			{
				
				System.out.println("the row count is "+i);
			int colCount=	sheet.getRow(i).getLastCellNum();
			
				for (int j = 0; j <colCount; j++) {
					
					String currentcell= sheet.getRow(i).getCell(j).getStringCellValue();
					
					FormulaEvaluator fe = workbook.getCreationHelper().createFormulaEvaluator();
					
					//System.out.println("column value"+j);
					System.out.println(currentcell);
					}
				
			}
		
		}
		
	
	
	

}
