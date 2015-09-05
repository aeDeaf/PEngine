package org.pixeles.engine;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
public class PEngine {
	
	//-------------------------------------------PEngine-------------------------------------------
	
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
	}
	
	//-------------------------------------------InitGL--------------------------------------------
	
	public void InitGL()
	{
		glMatrixMode(GL_PROJECTION);
	    glLoadIdentity();
	    glOrtho(0, 800, 0, 600, 1, -1);
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
		 glColor3f(0.5f,0.5f,1.0f);
         glBegin(GL_QUADS);
	     	glVertex2f(0,0);
	        glVertex2f(700,0);
	        glVertex2f(700,500);
	        glVertex2f(0,500);
	     glEnd();
	     Display.update();
	}
	
	//-------------------------------------------StopEngine----------------------------------------
	
	public void StopEngine()
	{
		Display.destroy();
		System.exit(0);
	}
}
