package main.java.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelParser
{
	private final XSSFWorkbook book;
	private XSSFSheet sheet;
	
	public ExcelParser(File file) throws IOException
	{
		book = new XSSFWorkbook(new FileInputStream(file));
		setSheet(0);
	}
	
	public void setSheet(int sheetNum)
	{
		this.sheet = book.getSheetAt(sheetNum);
	}
	
	public Cell getCell(int row, int column)
	{
		try
		{
			return sheet.getRow(row).getCell(column);
		}
		catch(NullPointerException e)
		{
			return null;
		}
	}
	
	public String readDataFromCell(int row, int column) // Starts from 0 by both axes
	{
		XSSFCell cell = (XSSFCell) getCell(row, column);
		if(cell == null) return null;
		
		return readDifferentCellTypes(cell, cell.getCellType());
	}
	
	public String readDifferentCellTypes(XSSFCell cell, CellType cellType)
	{
		switch(cellType)
		{
			case _NONE, BLANK ->
			{
				return "";
			}
			case NUMERIC ->
			{
				return cell.getNumericCellValue() + "";
			}
			case STRING ->
			{
				return cell.getStringCellValue();
			}
			case FORMULA ->
			{
				CellType cachedFormulaResultType = cell.getCachedFormulaResultType();
				return readDifferentCellTypes(cell, cachedFormulaResultType);
			}
			case BOOLEAN ->
			{
				return cell.getBooleanCellValue() + "";
			}
			case ERROR ->
			{
				return cell.getErrorCellString();
			}
			default -> throw new IllegalStateException("Unexpected value: " + cellType);
		}
	}
	
	public XSSFSheet getSheet()
	{
		return sheet;
	}
	
	public void close(File file)
	{
		try
		{
			book.write(new FileOutputStream(file));
			book.close();
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
