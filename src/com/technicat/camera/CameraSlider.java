package com.technicat.camera;

import com.technicat.jogl.*;
import com.technicat.view3d.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

/**
 * Copyright (c) 2006 Technicat, LLC
 * @author Phil Chu
 */
abstract public class CameraSlider extends JSlider implements ThreeD, ChangeListener {

    GLCameraApplication app;

    public CameraSlider(GLCameraApplication application) {
	app = application;
	setMinimum(getCameraMinimumValue());
	setMaximum(getCameraMaximumValue());
	setValue(getCameraValue());
	addChangeListener(this);
    }

    abstract protected int getCameraMinimumValue();
    abstract protected int getCameraMaximumValue();

    abstract protected int getCameraValue();

    protected float getRadians() {
	return ((float)getValue())*RADIANSPERDEGREES;
    }

    public void stateChanged(ChangeEvent event) {
	adjustCamera();
	app.redraw();
    }

    abstract protected void adjustCamera();

    protected int getSliderDegrees(float radians) {
	return (int)(radians*DEGREESPERRADIANS);
    }
}
