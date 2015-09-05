package org.pixeles.engine;

public class Pixel {
	private float r,g,b,a;
	
	//-------------------------------------------Pixel---------------------------------------------
	
	public Pixel()
	{
		r=g=b=a=0.0f;
	}
	
	//-------------------------------------------SetPixelColor-------------------------------------
	
	public void SetPixelColor(float rc, float gc, float bc, float ac)
	{
		r=rc;
		g=gc;
		b=bc;
		a=ac;
	}
	
	//-------------------------------------------ReturnRed-----------------------------------------
	
	public float ReturnRed()
	{
		return r;
	}
	
	//-------------------------------------------ReturnGrenn-----------------------------------------
	
	public float ReturnGreen()
	{
		return g;
	}
	
	//-------------------------------------------ReturnBlue-----------------------------------------
	
	public float ReturnBlue()
	{
		return b;
	}
	
	//-------------------------------------------ReturnAlpha-----------------------------------------
	
	public float ReturnAlpha()
	{
		return a;
	}
}