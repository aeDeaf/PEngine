package org.pixeles.engine;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
public class PEngine {
	
	//-------------------------------------------PEngine-------------------------------------------
	
	private int maxw=160;
	private int maxh=90;
	private Pixel buffer[][]=new Pixel[maxw][maxh];
	private int shiftw;
	private int shifth;
	private int w,h;
	private int psizex;
	private int psizey;
	public PEngine(int width, int height)
	{
		DisplayMode targetDisplayMode = null;
		try 
		{
			targetDisplayMode=Display.getDesktopDisplayMode(); //Получаем стандартное разрешение экрана
			Display.setDisplayMode(targetDisplayMode); //Устанавливаем режим работы дисплея
			Display.setFullscreen(true); //Устанавливаем полноэкранный режим
	        Display.create(); //Создаем дисплей
	    } 
		catch (LWJGLException e) 
		{
	        e.printStackTrace();
	        System.exit(0);
	    }
		if (width>Display.getWidth()) width=Display.getWidth();
		if (height>Display.getHeight()) height=Display.getHeight();
		shiftw=(Display.getWidth()-width)/2;
		shifth=(Display.getHeight()-height)/2;
		for (int i=0;i<maxw;i++)
		{
			for (int j=0;j<maxh;j++)
			{
				buffer[i][j]=new Pixel();
				buffer[i][j].SetPixelColor(0.26f,0.67f,1.0f,1.0f);
			}
		}
		for (int i=0;i<maxw;i++)
		{
			for (int j=0;j<30;j++)
			{
				buffer[i][j].SetPixelColor(0.59f,0.29f,0.0f,1.0f);
			}
		}
		for (int i=0;i<maxw;i++) buffer[i][30].SetPixelColor(0.0f,1.0f,0.0f,1.0f);
		w=width;
		h=height;
		psizex=w/maxw;
		psizey=h/maxh;
	}
	
	//-------------------------------------------InitGL--------------------------------------------
	
	public void InitGL()
	{
		glMatrixMode(GL_PROJECTION);
	    glLoadIdentity();
	    glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1, -1);
	    glMatrixMode(GL_MODELVIEW);
	}
	
	//-------------------------------------------IsComplete----------------------------------------
	
	public boolean IsCompete()
	{
		return Display.isCloseRequested();
	}
	
	//-------------------------------------------SetClearColor-------------------------------------
	
	public void SetClearColor(float rc, float gc, float bc, float ac)
	{
		glClearColor(rc,gc,bc,ac);
	}
	
	//-------------------------------------------ClearScreen---------------------------------------
	
	public void ClearScreen()
	{
		glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
	}
	
	//-------------------------------------------SwapBuffers---------------------------------------
	
	public void SwapBuffers()
	{
		for (int i=0;i<maxw;i++)
		{
			for (int j=0;j<maxh;j++)
			{
				float r,g,b,a;
				float x1,y1,x2,y2;
				Pixel p=buffer[i][j];
				r=p.ReturnRed();
				g=p.ReturnGreen();
				b=p.ReturnBlue();
				a=p.ReturnAlpha();
				glColor4f(r,g,b,a);
				x1=shiftw+(i*psizex);
				x2=x1+psizex;
				y1=shifth+(j*psizey);
				y2=y1+psizey;
				glBegin(GL_QUADS);
					glVertex2f(x1,y1);
					glVertex2f(x2,y1);
					glVertex2f(x2,y2);
					glVertex2f(x1,y2);
				glEnd();
			}
		}
		Display.update();
	}
	
	//-------------------------------------------StopEngine----------------------------------------
	
	public void StopEngine()
	{
		Display.destroy();
		System.exit(0);
	}
	
	//-------------------------------------------MouseHandler--------------------------------------
	
	public void MouseHandler()
	{
		if (Mouse.isButtonDown(0)) 
		{
	        int mx = (Mouse.getX()-shiftw)/psizex;
	        int my = (Mouse.getY()-shifth)/psizey;
	        buffer[mx][my].SetPixelColor(0.59f, 0.29f, 0.0f, 1.0f);
		}
		if (Mouse.isButtonDown(1)) 
		{
	        int mx = (Mouse.getX()-shiftw)/psizex;
	        int my = (Mouse.getY()-shifth)/psizey;
	        buffer[mx][my].SetPixelColor(0.0f, 1.0f, 0.0f, 1.0f);
		}
	}
	
	//-------------------------------------------DrawImage-----------------------------------------
	
	public void DrawImage(Image image)
	{
		for (int i=0;i<image.ReturnWidth();i++)
		{
			for (int j=0;j<image.ReturnHeight();j++)
			{
				buffer[image.ReturnX()+(image.ReturnWidth()-i)][image.ReturnY()+(image.ReturnHeight()-j)]=
						image.image[i][j];
			}
		}
	}
}