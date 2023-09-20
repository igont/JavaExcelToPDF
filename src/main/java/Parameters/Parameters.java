package main.java.Parameters;

public class Parameters
{
	private float height;
	private float width;
	
	public void setMillimeterSize(float height, float width)
	{
		this.height = (float) (height * 72 / 25.4);
		this.width = (float) (width * 72 / 25.4);
	}
	
	public void setMillimeterSize(PaperSize size)
	{
		switch(size)
		{
			
			case A0 ->
			{
				height = 1189;
				width = 841;
			}
			case A1 ->
			{
				height = 841;
				width = 594;
			}
			case A2 ->
			{
				height = 594;
				width = 420;
			}
			case A3 ->
			{
				height = 420;
				width = 297;
			}
			case A4 ->
			{
				height = 297;
				width = 210;
			}
			case A5 ->
			{
				height = 210;
				width = 148;
			}
			case A6 ->
			{
				height = 148;
				width = 105;
			}
		}
		height = (float) (height * 72 / 25.4);
		width = (float) (width * 72 / 25.4);
	}
	
	private float marginLeft;
	private float marginRight;
	private float marginUp;
	private float marginDown;
	
	public void setMargins(int all)
	{
		marginLeft = all;
		marginRight = all;
		marginUp = all;
		marginDown = all;
	}
	
	public void setMillimeterMargins(float marginLeft, float marginRight, float marginUp, float marginDown)
	{
		this.marginLeft = marginLeft;
		this.marginRight = marginRight;
		this.marginUp = marginUp;
		this.marginDown = marginDown;
	}
	
	private boolean albumOrientation;
	
	public void setAlbumOrientation(boolean album)
	{
		albumOrientation = album;
		
		if(albumOrientation)
		{
			if(height > width) changeSizes();
		}
		else
		{
			if(height < width) changeSizes();
		}
	}
	
	private void changeSizes()
	{
		float f = height;
		height = width;
		width = f;
	}
	
	private float printScale = 100;
	
	public void setPrintScale(float printScale)
	{
		this.printScale = printScale;
	}
	
	public void fitHorizontal(float horizontalSize)
	{
		printScale = fit(width - marginRight - marginLeft, horizontalSize);
	}
	
	public void fitVertical(float verticalSize)
	{
		printScale = fit(height - marginDown - marginUp, verticalSize);
	}
	
	private float fit(float paperSize, float realSize)
	{
		return paperSize / realSize;
	}
	
	private String pathToSave;
	private String pathReadFrom;
	
	public String getPathToSave()
	{
		return pathToSave;
	}
	
	public void setPathToSave(String pathToSave)
	{
		this.pathToSave = pathToSave;
	}
	
	public String getPathReadFrom()
	{
		return pathReadFrom;
	}
	
	public void setPathReadFrom(String pathReadFrom)
	{
		this.pathReadFrom = pathReadFrom;
	}
	
	public float getHeight()
	{
		return height;
	}
	
	public float getWidth()
	{
		return width;
	}
	
	public float getMarginLeft()
	{
		return marginLeft;
	}
	
	public float getMarginRight()
	{
		return marginRight;
	}
	
	public float getMarginUp()
	{
		return marginUp;
	}
	
	public float getMarginDown()
	{
		return marginDown;
	}
	
	public boolean isAlbumOrientation()
	{
		return albumOrientation;
	}
	
	public float getPrintScale()
	{
		return printScale;
	}
}
