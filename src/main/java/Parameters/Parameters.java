package main.java.Parameters;

public class Parameters
{
	private float height;
	private float width;
	
	public void setSize(float height, float width)
	{
		this.height = height;
		this.width = width;
	}
	
	public void setSize(PaperSize size)
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
	
	public void setMargins(float marginLeft, float marginRight, float marginUp, float marginDown)
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
	
	private float scale;
	
	public void setScale(float scale)
	{
		this.scale = scale;
	}
	
	public void fitHorizontal(float horizontalSize)
	{
		scale = fit(width - marginRight - marginLeft, horizontalSize);
	}
	
	public void fitVertical(float verticalSize)
	{
		scale = fit(height - marginDown - marginUp, verticalSize);
	}
	
	private float fit(float paperSize, float realSize)
	{
		return paperSize / realSize;
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
	
	public float getScale()
	{
		return scale;
	}
}
