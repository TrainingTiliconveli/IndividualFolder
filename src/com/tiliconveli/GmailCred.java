package com.tiliconveli;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class GmailCred {
	 public static void main(String[] args) throws IOException{

		 FileInputStream file = new FileInputStream(new File("D:\\Logindetails.xls"));
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\subu\\Documents\\geckodriver.exe"); 
		 WebDriver driver = new FirefoxDriver();
		 driver.get("https://accounts.google.com/ServiceLogin/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.co.in%2Fsearch%3Fq%3Dcollections%2Bquestions%26rlz%3D1C1CHBD_enIN716IN716%26oq%3Dcollections%2Bquestions%26aqs%3Dchrome..69i57j69i59j0l2j69i60j0.6634j0j7%26sourceid%3Dchrome%26ie%3DUTF-8&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		 //Get the workbook instance for XLS file 
		 @SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		 //Get first sheet from the workbook
		 HSSFSheet sheet = workbook.getSheetAt(0);

		 //Iterate through each rows from first sheet
		 Iterator<Row> rowIterator = sheet.iterator();

		 while(rowIterator.hasNext()) {

		 Row row = rowIterator.next();

		 //For each row, iterate through each columns
		 Iterator<Cell> cellIterator = row.cellIterator();
		 while(cellIterator.hasNext()) {        

		 Cell cell = cellIterator.next();
		  if(cell.getColumnIndex() == 0){
		      
		                 driver.findElement(By.xpath(".//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[1]")).sendKeys(cell.getStringCellValue());
	                      driver.findElement(By.xpath(".//*[@id='passwordNext']/div[2]")).click();	             
		  }
		            
		                 driver.findElement(By.xpath(".//*[@id='password']/div[1]")).sendKeys(cell.getStringCellValue());

		                 driver.findElement(By.xpath(".//*[@id='passwordNext']/div[2]")).click();
		         }

		     }
		     }
		 }

