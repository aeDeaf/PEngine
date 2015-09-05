package org.pixeles.testgame;
import org.pixeles.engine.Image;
import org.pixeles.engine.PEngine;
  
public class TestGame {
	public static void main(String[] argv) 
	{
		PEngine engine =new PEngine(1920,1280);
		Image image = new Image("Image1.ipf",50,30);
		engine.InitGL();
		engine.SetClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		while (!(engine.IsCompete()))
		{
			engine.ClearScreen();
			engine.MouseHandler();
			engine.DrawImage(image);
			engine.SwapBuffers();
		}
		engine.StopEngine();
    }
}