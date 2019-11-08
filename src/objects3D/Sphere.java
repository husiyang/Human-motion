package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Sphere {

	
	public Sphere() {

	}
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	// 7b should be your primary source, we will cover more about circles in later lectures to understand why the code works 
	public void DrawSphere(float radius,float nSlices,float nSegments) {
		float inctheta = (float) ((2.0f*Math.PI)/nSlices);
		float incphi = (float) (Math.PI/nSegments);
		GL11.glBegin(GL11.GL_QUADS);
		for(float theta = (float) (-Math.PI); theta < Math.PI; theta += inctheta) {
			for(float phi = (float) (-Math.PI/2.0f); phi < (Math.PI/2.0f); phi += incphi) {
				float r = (float) (radius*Math.cos(phi));
				float z = (float) (radius*Math.sin(phi));
				float x = (float) (r*Math.cos(theta));
				float y = (float) (r*Math.sin(theta));
				float x1 = (float) (r*Math.cos(theta + inctheta));
				float y1 = (float) (r*Math.sin(theta + inctheta));
				float r2 = (float) (radius*Math.cos(phi + incphi));
				float z2 = (float) (radius*Math.sin(phi + incphi));
				float x2 = (float) (r2*Math.cos(theta));
				float y2 = (float) (r2*Math.sin(theta));
				float x3 = (float) (r2*Math.cos(theta + inctheta));
				float y3 = (float) (r2*Math.sin(theta + inctheta));
				GL11.glNormal3f(x, y, z);
				GL11.glVertex3f(x,y,z);
				GL11.glNormal3f(x1, y1,z);
				GL11.glVertex3f(x1,y1,z);
				GL11.glNormal3f(x3, y3, z2);
				GL11.glVertex3f(x3,y3,z2);
				GL11.glNormal3f(x2, y2, z2);
				GL11.glVertex3f(x2,y2,z2);
			}
		}
		GL11.glEnd();
	}
}

 