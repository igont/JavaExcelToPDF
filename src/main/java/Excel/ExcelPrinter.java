package Excel;

import Parameters.Parameters;

public class ExcelPrinter
{
	private Parameters parameters;
	private ExcelParser excelParser;
	
	public ExcelPrinter(Parameters parameters, ExcelParser excelParser)
	{
		this.parameters = parameters;
		this.excelParser = excelParser;
	}
}
