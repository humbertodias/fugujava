package com.technicat.camera;

import com.technicat.jogl.*;
import com.technicat.view3d.*;

import javax.swing.*;

/**
 * Copyright (c) 2006 Technicat, LLC
 * @author Phil Chu
 */
public class DistanceSlider extends CameraSlider {

    public DistanceSlider(GLCameraApplication application) {
	super(application);
	setToolTipText("Camera distance");
	setOrientation(SwingConstants.VERTICAL);
    }

    protected int getCameraValue() {
	return (int)app.getCamera().getDistance();
    }

    protected int getCameraMinimumValue() {
	return 0;
    }

    protected int getCameraMaximumValue() {
	return 1000;
    }

    protected void adjustCamera() {
	app.getCamera().setDistance((float)getValue());
	setToolTipText("Camera  distance is ");
    }

}
