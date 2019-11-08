package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import java.math.*;

public class Cylinder {

	
	public Cylinder() { 
	}
	
	// remember to use Math.PI isntead PI 
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCylinder(float radius, float height, int nSegments ) 
	{
		GL11.glBegin(GL11.GL_TRIANGLES);
		for(float i = 0; i < nSegments; i += Math.PI*radius*2.0/nSegments) {
			float angle = (float) (Math.PI*i*2.0);
			float nextAngle = (float) (Math.PI*(i+Math.PI*radius*2.0/nSegments)*2.0);
			float x1 = (float) (radius*Math.sin(angle)), y1 = (float) (radius*Math.cos(angle));
			float x2 = (float) (radius*Math.sin(nextAngle)), y2 = (float) (radius*Math.cos(nextAngle));
			GL11.glNormal3f(x1, y1,0.0f);	
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glNormal3f(x2, y2,0.0f);	
			GL11.glVertex3f(x2, y2, height);
			GL11.glNormal3f(x1, y1,0.0f);	
			GL11.glVertex3f(x1, y1, height);
			GL11.glNormal3f(x1, y1,0.0f);	
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glNormal3f(x2, y2,0.0f);	
			GL11.glVertex3f(x2, y2, 0.0f);
			GL11.glNormal3f(x2, y2,0.0f);	
			GL11.glVertex3f(x2, y2, height);
			
			Vector4f v = new Point4f(x1,y1,0.0f,0.0f).MinusPoint(new Point4f(0.0f,0.0f,0.0f,0.0f));
			Vector4f w = new Point4f(x2,y2,0.0f,0.0f).MinusPoint(new Point4f(0.0f,0.0f,0.0f,0.0f));
			Vector4f normal2 = v.cross(w).Normal();
			GL11.glNormal3f(normal2.x, normal2.y, normal2.z);
			GL11.glVertex3f(0.0f,0.0f,0.0f);
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glVertex3f(x2, y2, 0.0f);
			GL11.glVertex3f(0.0f,0.0f,height);
			GL11.glVertex3f(x1, y1, height);
			GL11.glVertex3f(x2, y2, height);
		}
		GL11.glEnd();
	}
}
