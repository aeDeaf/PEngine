package org.pixeles.engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Map {
	public Pixel map[][];
	private int maxw, maxh;
	public Map(int mw, int mh)
	{
		maxw=mw;
		maxh=mh;
		map=new Pixel[maxw][maxh];
		for (int j=0;j<maxh;j++)
		{
			for (int i=0;i<maxw;i++)
			{
				map[i][j]=new Pixel();
			}
		}
	}
	public void LoadMap(String path)
	{
		try 
		{
			Scanner sc=new Scanner(new File(path));
			for (int j=0;j<maxh;j++)
			{
				for (int i=0;i<maxw;i++)
				{
					float r=sc.nextInt()/255;
					float g=sc.nextInt()/255;
					float b=sc.nextInt()/255;
					float a=sc.nextFloat();
					map[i][j].SetPixelColor(r, g, b, a);
				}
			}
			sc.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Sorry, File not found");
			System.exit(0);
		}
	}
}
