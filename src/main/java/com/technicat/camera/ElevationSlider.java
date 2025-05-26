package com.technicat.camera;

import com.technicat.view3d.*;
import com.technicat.jogl.*;

import javax.swing.*;

/**
 * Copyright (c) 2006 Technicat, LLC
 * @author Phil Chu
 */
public class ElevationSlider extends CameraRotationSlider {

    public ElevationSlider(GLCameraApplication application) {
	super(application);
	setToolTipText("Camera elevation");
	setOrientation(SwingConstants.VERTICAL);
    }

    protected int getCameraValue() {
	return getSliderDegrees(app.getCamera().getElevation());
    }

    protected void adjustCamera() {
	app.getCamera().setElevation(getRadians());
	setToolTipText("Camera elevation is "+getRadians()+" radians");
    }
}
