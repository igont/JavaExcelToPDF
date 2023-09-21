package main.java.Excel;


import main.java.Parameters.Parameters;
import main.java.Parameters.Point;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.File;
import java.io.IOException;

public class ExcelPrinter
{
	private final Parameters parameters;
	private ExcelParser excelParser;
	private PDDocument document = new PDDocument();
	private int activePage = -1;
	
	public ExcelPrinter(Parameters parameters) throws IOException
	{
		this.parameters = parameters;
		this.excelParser = new ExcelParser(new File(parameters.getPathReadFrom()));
	}
	
	public void print() throws IOException
	{
		readDiapason(2, 8, 2, 5);
		addPage();
		drawMargins();
		save();
	}
	
	private void readDiapason(int startRow, int endRow, int startColumn, int endColumn)
	{
		for(int row = startRow; row <= endRow; row++)
		{
			for(int col = startColumn; col <= endColumn; col++)
			{
				Cell cell = excelParser.getCell(row, col);
				String cellText = excelParser.readDifferentCellTypes((XSSFCell) cell, cell.getCellType());
				int heightInPoints = cell.getRow().getHeight();
				int widthInPoints = cell.getSheet().getColumnWidth(cell.getColumnIndex());
			}
		}
	}
	
	private void drawCell()
	{
	
	}
	
	private void drawMargins() throws IOException
	{
		PDPageContentStream contentStream = new PDPageContentStream(document, document.getPage(activePage), PDPageContentStream.AppendMode.APPEND,false);
		
		contentStream.setLineWidth(0.5f);
		contentStream.setLineDashPattern(new float[]{7,3,0.01f,3,},0);
		contentStream.setStrokingColor(0.5f);
		contentStream.setLineCapStyle(1);
		contentStream.setLineJoinStyle(1);
		
		Point dot = new Point(parameters.getMarginLeft(), parameters.getMarginDown());
		
		lineTo(contentStream, dot, 0, parameters.getActiveHeight());
		lineTo(contentStream, dot, parameters.getActiveWidth(),0);
		lineTo(contentStream, dot, 0, -parameters.getActiveHeight());
		lineTo(contentStream, dot, -parameters.getActiveWidth(),0);
		
		contentStream.close();
	}
	
	private void lineTo(PDPageContentStream contentStream, Point dot, float hor, float ver) throws IOException
	{
		contentStream.moveTo(dot.hor, dot.ver);
		dot.move(hor,ver);
		contentStream.lineTo(dot.hor, dot.ver);
		contentStream.stroke();
	}
	
	private void addPage()
	{
		PDRectangle rectangle = new PDRectangle(parameters.getWidth(), parameters.getHeight());
		PDPage page = new PDPage(rectangle);
		document.addPage(page);
		activePage++;
	}
	
	private void save() throws IOException
	{
		File output = new File(parameters.getPathToSave());
		output.getParentFile().mkdirs();
		
		document.save(output);
		document.close();
	}
	
}
