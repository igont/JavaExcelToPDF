package main.java.Parameters;

public class Point
{
	public float hor;
	public float ver;
	
	public Point(float x, float y)
	{
		this.hor = x;
		this.ver = y;
	}
	
	public void moveHorizontal(float hor)
	{
		this.hor += hor;
	}
	
	public void moveVertical(float ver)
	{
		this.ver += ver;
	}
	
	public void move(float hor, float ver)
	{
		this.hor += hor;
		this.ver += ver;
	}
}
