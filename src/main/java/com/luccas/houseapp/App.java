package com.luccas.houseapp;

import javax.swing.JFrame;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(new Renderer());
        
        JFrame frame = new JFrame("JOGL House");
        frame.getContentPane().add(canvas);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
