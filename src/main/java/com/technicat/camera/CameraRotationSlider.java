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
abstract public class CameraRotationSlider extends CameraSlider implements ThreeD, ChangeListener {

    public CameraRotationSlider(GLCameraApplication application) {
	super(application);
    }

    protected int getCameraMinimumValue() {
	return -180;
    }

    protected int getCameraMaximumValue() {
	return 180;
    }
}
