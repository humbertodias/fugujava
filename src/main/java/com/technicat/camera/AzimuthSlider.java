package com.technicat.camera;

import com.technicat.jogl.*;
import com.technicat.view3d.*;

import javax.swing.*;

/**
 * Copyright (c) 2006 Technicat, LLC
 * @author Phil Chu
 */
public class AzimuthSlider extends CameraRotationSlider {

    public AzimuthSlider(GLCameraApplication application) {
	super(application);
	setToolTipText("Camera azimuth");
    }

    protected int getCameraValue() {
	return getSliderDegrees(app.getCamera().getAzimuth());
    }

    protected void adjustCamera() {
	app.getCamera().setAzimuth(getRadians());
	setToolTipText("Camera azimuth is "+getRadians()+" radians");
    }

}
