package org.pixeles.engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Image {
	public Pixel image[][]=new Pixel[20][20];
	private int width;
	private int height;
	private int x;
	private int y;
	public Image(String path,int xpos, int ypos)
	{
		x=xpos;
		y=ypos;
		for (int i=0;i<20;i++)
		{
			for (int j=0;j<20;j++)
			{
				image[i][j]=new Pixel();
			}
		}
		try
		{
		Scanner sc=new Scanner(new File(path));
		int w=sc.nextInt();
		int h=sc.nextInt();
		width=w;
		height=h;
		for (int j=0;j<h;j++)
		{
			for (int i=0;i<w;i++)
			{
				float r=sc.nextFloat()/255;
				float g=sc.nextFloat()/255;
				float b=sc.nextFloat()/255;
				image[i][j].SetPixelColor(r, g, b, 1.0f);
			}
			System.out.printf("\n"); 
		}
		sc.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Sorry, File not found!");
			System.exit(0);
		}
	}
	public int ReturnWidth()
	{
		return width;
	}
	public int ReturnHeight()
	{
		return height;
	}
	public int ReturnX()
	{
		return x;
	}
	public int ReturnY()
	{
		return y;
	}
}
