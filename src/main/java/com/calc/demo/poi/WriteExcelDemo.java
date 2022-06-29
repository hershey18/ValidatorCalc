package com.calc.demo.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcelDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("t1");
		Date date =  new Date();
		
		LocalDateTime now = LocalDateTime.now();//.now();
		System.out.println(now.getMinute());
		
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		System.out.println("t2");
		XSSFSheet sheet = workbook.createSheet("Data " + now.getMinute());

		try {
			
			final int sheetNo = 0;

		    if (workbook != null)
		    {
		    	System.out.println("inside wb try"+now.getMinute());
		    		String y=Integer.toString(now.getMinute()); 

		        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
		        	System.out.println("inside wb for"+now.getMinute());
		            System.out.println("Sheet name: " + workbook.getSheetName(i));
		        }
		        sheet = workbook.cloneSheet(sheetNo);
		       
		        int newSheetNo = workbook.getSheetIndex(sheet);
		        workbook.setSheetName(newSheetNo,y+"J");
		       
		    }
			
			
		//Create a blank sheet
		System.out.println("t3");
		//This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("01", new Object[] {"Token", "Operator Address"});
		data.put("02", new Object[] {"Token Type", "Name", "Address", "Total Token Balance", "Available Balance","Delegated Amount", "Rewards", "Commission", "APY", "Commission Rate", "Price at month end"});
		data.put("03", new Object[] {"MATIC","MATIC"});
		data.put("04", new Object[] {"DVPN","DVPN"});
		data.put("05", new Object[] {"KAI","KAI"});
		data.put("06", new Object[] {"LUNA","LUNA"});
		data.put("07", new Object[] {"FUSE","FUSE"});
		data.put("08", new Object[] {"NGM","NGM"});
		data.put("09", new Object[] {"KAVA","KAVA"});
		data.put("10", new Object[] {"Tomo","Tomo"});
		data.put("11", new Object[] {"Bluzelle","Bluzelle"});
		data.put("12", new Object[] {"ATOM","ATOM"});
		data.put("13", new Object[] {"DOT","DOT #1 - Stash"});
		data.put("14", new Object[] {"BAND", "BAND"});
		data.put("15", new Object[] {"KSM", "KSM #2 - Stash"});
		data.put("16", new Object[] {"KSM", "KSM #1 - Stash"});
		data.put("17", new Object[] {"DOT","DOT #2 - Stash"});
		data.put("18", new Object[] {" "});
		data.put("19", new Object[] {" "});
		
		LocalDateTime now1 = LocalDateTime.now();//.now();
		System.out.println(now1.getMinute());
		
		//Blank workbook
		//XSSFWorkbook workbook = new XSSFWorkbook(); 
		System.out.println("t2");
		//XSSFSheet sheet = workbook.createSheet("Data " + now.getMinute());

//		   if (workbook == null)
//		    {
//
//		        for (int i = 0; i < workbook.getNumberOfSheets(); i++) 
//		        {
//		            System.out.println("Sheet name: " + workbook.getSheetName(i));
//		        }
//		        sheet = workbook.cloneSheet(sheetNo);
//		        int newSheetNo = workbook.getSheetIndex(sheet);
//		        workbook.setSheetName(newSheetNo,now1.toString()+"j");
//		       
//		    }

//		   Map<String, Object[]> data1 = new TreeMap<String, Object[]>();
//		
//		data.put("20", new Object[] {"Owner Address", "Owner Address"});
//		data.put("21", new Object[] {"Token Type", "Name", "Address", "Total Token Balance", "Available Balance","Delegated Amount", "Rewards", "Commission", "APY", "Commission Rate", "Price at month end"});
//		data.put("22", new Object[] {"KAI","KAI"});
//		data.put("23", new Object[] {"FUSE","FUSE"});
//		data.put("24", new Object[] {"DVPN","DVPN"});
//		data.put("25", new Object[] {"Tomo","Tomo"});
//		data.put("26", new Object[] {"NGM","NGM"});
//		data.put("27", new Object[] {"DOT","DOT #1 - Controller"});
//		data.put("28", new Object[] {"LUNA","LUNA"});
//		data.put("29", new Object[] {"Bluzelle","Bluzelle"});
//		data.put("30", new Object[] {"KAVA","KAVA"});
//		data.put("31", new Object[] {"BAND", "BAND"});
//		data.put("32", new Object[] {"ATOM","ATOM"});
//		data.put("33", new Object[] {"KSM", "KSM #2 - Controller"});
//		data.put("34", new Object[] {"KSM", "KSM #1 - Controller"});
//		data.put("35", new Object[] {"DOT","DOT #2 - Controller"});
//		data.put("36", new Object[] {"MATIC","MATIC"});
//		System.out.println("t4");
		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset)
		{
		    Row row = sheet.createRow(rownum++);
		    Object [] objArr = data.get(key);
		    int cellnum = 0;
		    for (Object obj : objArr)
		    {
		       Cell cell = row.createCell(cellnum++);
		       if(obj instanceof String)
		            cell.setCellValue((String)obj);
		        else if(obj instanceof Integer)
		            cell.setCellValue((Integer)obj);
		    }
		}
		    
		try 
		{
			System.out.println("Test1");
			//Write the workbook in file system
		    FileOutputStream out = new FileOutputStream(new File("ValidatorCalc.xlsx"));
		    workbook.setActiveSheet(1);
		    workbook.write(out);
		    workbook.setActiveSheet(0);
		    workbook.write(out);
		    out.close();
		    
		    System.out.println("File written successfully on disk.");
		 }    
		
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
		}
		catch(Exception e)
		{
			   e.printStackTrace();
		}
		
	}
}
