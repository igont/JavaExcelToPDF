package main.java.Excel;


import main.java.Parameters.Parameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.File;
import java.io.IOException;

public class ExcelPrinter
{
	private Parameters parameters;
	private ExcelParser excelParser;
	private PDDocument document = new PDDocument();
	
	public ExcelPrinter(Parameters parameters) throws IOException
	{
		excelParser = new ExcelParser(new File(parameters.getPathReadFrom()));
		
		this.parameters = parameters;
		this.excelParser = excelParser;
	}
	
	public void print() throws IOException
	{
		addPage();
		save();
	}
	private void addPage()
	{
		PDRectangle rectangle = new PDRectangle(parameters.getWidth(), parameters.getHeight());
		PDPage page = new PDPage(rectangle);
		document.addPage(page);
	}
	
	private void save() throws IOException
	{
		File output = new File(parameters.getPathToSave());
		output.getParentFile().mkdirs();
		
		document.save(output);
		document.close();
	}
	
}
