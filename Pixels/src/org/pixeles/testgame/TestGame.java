package org.pixeles.testgame;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.pixeles.engine.PEngine;
  
public class TestGame {
	public static void main(String[] argv) 
	{
		PEngine engine=new PEngine(Display.getWidth(),Display.getHeight());
		engine.InitGL();
		engine.SetClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		while (!(engine.IsCompete()))
		{
			engine.ClearScreen();
			engine.SwapBuffers();
		}
		engine.StopEngine();
    }
}