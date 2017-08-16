package com.luccas.houseapp;

import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;

public class Renderer implements GLEventListener{

	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glMatrixMode(GL2.GL_MATRIX_MODE);
		gl.glLoadIdentity();
		
		GLU glu = new GLU();
		glu.gluOrtho2D(0.0, 200.0, 0.0, 200.0); // 2D orthogonal projection
		
	}

	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glColor3f(1f,1f,1f);
		
		drawHouse(gl);
		//drawMinas(gl);
		
		gl.glFlush();
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	private void drawHouse(GL2 gl) {
		double phi = 30; // Perspective angle
		int len = 100;
		
		gl.glBegin(GL2.GL_QUAD_STRIP);
		
		gl.glColor3ub((byte) 51, (byte) 204, (byte) 51);
		gl.glVertex2i(10, 10); // P1
		gl.glVertex2i(10, 100); //P2 
		gl.glVertex2i(60, 10); // P3
		gl.glVertex2i(60, 100); // P4
		
		gl.glColor3ub((byte) 0, (byte) 153, (byte) 51); 
		int dx = (int) (len * Math.cos(Math.toDegrees(phi)));
		int dy = (int) (len * Math.sin(Math.toDegrees(phi)));
		gl.glVertex2i(60 - dx, 10 - dy); // P5
		gl.glVertex2i(60 - dx, 100 - dy); // P6
		
		gl.glEnd();
		
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		
		gl.glColor3ub((byte) 204, (byte) 52, (byte) 0);
		gl.glVertex2i(10, 100);
		gl.glVertex2i(30, 150);
		gl.glVertex2i(60, 100);
		
		gl.glColor3ub((byte) 153, (byte) 51, (byte) 0);
		int p6x = 60 - dx;
		int p6y = 100 - dy;
		
		dx = (int) (len * Math.cos(Math.toDegrees(phi)));
		dy = (int) (len * Math.sin(Math.toDegrees(phi)));
		
		gl.glVertex2i(30 - dx, 150 - dy);
		gl.glVertex2i(p6x, p6y);
		
		gl.glEnd();
		
	}
	
	private void drawMinas(GL2 gl) {
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2i(0, 0);
		gl.glVertex2i(200, 0);
		gl.glVertex2i(200, 200);
		gl.glVertex2i(0, 200);
		gl.glEnd();
		
		gl.glColor3ub((byte) 51, (byte) 204, (byte) 51); 
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glVertex2i(100,100);
		gl.glVertex2i(100, 150);
		gl.glVertex2i(50, 100);

		gl.glColor3ub((byte) 0, (byte) 153, (byte) 51); 
		gl.glVertex2i(100,100);
		gl.glVertex2i(100, 150);
		gl.glVertex2i(150, 100);
		gl.glEnd();
		
	}

}
