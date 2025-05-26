package com.technicat.camera;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.technicat.view3d.*;
import com.technicat.jogl.*;
import com.technicat.swing.*;
import javafx.scene.PerspectiveCamera;

import javax.vecmath.*;
//import javax.media.opengl.*;
//import javax.media.opengl.glu.*;

import javax.swing.*;
import java.awt.*;

/**
 * A JOGL Application with a camera
 * Copyright 2006 Technicat, LLC
 * @author Phil Chu
 */
abstract public class GLCameraApplication extends GLApplication {

    private PerspectiveCamera camera;
    private GLU glu;
    private double aspect;

    public GLCameraApplication() {
	glu = new GLU();
    }

    public void display(GLAutoDrawable drawable) {
	super.display(drawable);
	useCameraProjection(drawable.getGL());
	useCamera(drawable.getGL());
    }

    public PerspectiveCamera getCamera() {
	return camera;
    }

    protected GLU getGLU() {
	return glu;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
	aspect = (double)width/(double)height;
    }

    public void setCamera(PerspectiveCamera camera) {
	this.camera = camera;
    }

    private void useCamera(GL gl) {
	Point3f aimpoint = camera.getAimPoint();
	gl.glTranslatef(camera.getPanX(), camera.getPanY(), -camera.getDistance());
	gl.glRotatef(camera.getElevation(), 1, 0, 0);
	gl.glRotatef(camera.getAzimuth(), 0, 1, 0);
	gl.glTranslatef(aimpoint.x,aimpoint.y,aimpoint.z);
    }

    private void useCameraProjection(GL gl) {
	gl.glMatrixMode(GL.GL_PROJECTION);
	gl.glLoadIdentity();
	glu.gluPerspective(camera.getFOV(),
			   aspect,1.0,100.0);
	//    Sz = D*math:tan(Fov*math:pi()/180/2),
	//	    gl:ortho(-Sz*Aspect, Sz*Aspect, -Sz, Sz, Hither, Yon)
	gl.glMatrixMode(GL.GL_MODELVIEW);
    }

    public void setContainer(ApplicationContainer frame) {
	super.setContainer(frame);
	JSlider sliderx = new JSlider();
	getRootPane().getContentPane().add(new AzimuthSlider(this),
					   BorderLayout.SOUTH);
	getRootPane().getContentPane().add(new ElevationSlider(this),
					   BorderLayout.EAST);
	getRootPane().getContentPane().add(new FOVSlider(this),
					   BorderLayout.NORTH);
	getRootPane().getContentPane().add(new DistanceSlider(this),
					   BorderLayout.WEST);
    }
    
}
