package com.technicat.camera;

import com.technicat.jogl.*;
import com.technicat.view3d.*;

import javax.swing.*;

/**
 * Copyright (c) 2006 Technicat, LLC
 * @author Phil Chu
 */
public class FOVSlider extends CameraSlider {

    public FOVSlider(GLCameraApplication application) {
	super(application);
	setToolTipText("Camera FOV");
    }

    protected int getCameraValue() {
	return getSliderDegrees(app.getCamera().getFOV());
    }

    protected int getCameraMinimumValue() {
	return 0;
    }
    
    protected int getCameraMaximumValue() {
	return 180;
    }

    protected void adjustCamera() {
	app.getCamera().setFOV(getRadians());
	setToolTipText("Camera FOV is "+getRadians()+" radians");
    }

}
