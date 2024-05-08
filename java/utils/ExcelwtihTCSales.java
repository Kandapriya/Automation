package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelwtihTCSales {

	public static String[][] excelData(String filedata) throws IOException {
		// TODO Auto-generated method stub
		//STEP 1:
		XSSFWorkbook wb=new XSSFWorkbook("./DataExeclsheet/"+filedata+".xlsx");
		
		//STEP2:
		XSSFSheet sheet=wb.getSheetAt(0);
		
		//STEP3:
		XSSFRow row=sheet.getRow(1);
		int rowcount = sheet.getLastRowNum();
		//System.out.println("The Row Count without headervalue:"+rowcount);
		
		//step4:
		short Cellcount = row.getLastCellNum();
		//System.out.println("The cell count :"+Cellcount);
		
		//twodimension array to connect with TC:
		String[][] data=new String[rowcount][Cellcount];
		
		//step5:
		for (int i = 1; i <=rowcount; i++) {
			for (int j = 0; j < Cellcount; j++) {
			String CellValue = sheet.getRow(i).getCell(j).getStringCellValue();
			System.out.println(" The cell value :"+CellValue);
			//Save data into the 2D array:
			data[i-1][j]=CellValue;
				
			}
			
		}
		
	wb.close();
	return data;

	}

}
