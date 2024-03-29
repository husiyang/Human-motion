package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class TexCube {

	static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
	static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
	static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };
	public TexCube() {

	}
	
	// Implement using notes  and looking at TexSphere
	public void DrawTexCube(Texture myTexture) {
		Point4f vertices[] = {  new Point4f(-1.0f, -1.0f, -1.0f, 0.0f), 
				new Point4f(-1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, -1.0f, 0.0f), 
				new Point4f(-1.0f, 1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, -1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, 1.0f, -1.0f, 0.0f), 
				new Point4f(1.0f, 1.0f, 1.0f, 0.0f) };

		int faces[][] = { 	{ 0, 4, 5, 1 }, 
			{ 0, 2, 6, 4 }, 
			{ 0, 1, 3, 2 }, 
			{ 4, 6, 7, 5 },
			{ 1, 5, 7, 3 },
			{ 2, 3, 7, 6 } };
		
		GL11.glBegin(GL11.GL_QUADS);
		for (int face = 0; face < 6; face++) { // per face
			Vector4f v = vertices[faces[face][1]].MinusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][3]].MinusPoint(vertices[faces[face][0]]);
			Vector4f normal = v.cross(w).Normal();

			GL11.glNormal3f(normal.x, normal.y, normal.z); 
			//per corner
			GL11.glTexCoord2f(0.0f,0.0f);//bottom left corner
			GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
			
			GL11.glTexCoord2f(1.0f,0.0f);//bottom right corner
			GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			
			GL11.glTexCoord2f(1.0f,1.0f);//top right corner
			GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
			
			GL11.glTexCoord2f(0.0f,1.0f);//top left corner
			GL11.glVertex3f(vertices[faces[face][3]].x, vertices[faces[face][3]].y, vertices[faces[face][3]].z);
		} // per face
		
		GL11.glEnd();
	}	
}
 
	/*
	 
	 
}

	*/
	 