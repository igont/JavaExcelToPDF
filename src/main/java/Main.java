package main.java;

import main.java.Excel.ExcelPrinter;
import main.java.Parameters.PaperSize;
import main.java.Parameters.Parameters;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		Parameters parameters = new Parameters();
		
		parameters.setPathToSave("C:/Users/Igor/Desktop/Тест.pdf");
		parameters.setPathReadFrom("C:/Users/Igor/Desktop/Тест.xlsx");
		
		parameters.setMargins(5);
		parameters.setMillimeterSize(PaperSize.A4);
		parameters.setAlbumOrientation(false);
		
		ExcelPrinter excelPrinter = new ExcelPrinter(parameters);
		
		excelPrinter.print();
		sc.nextLine();
	}
}
