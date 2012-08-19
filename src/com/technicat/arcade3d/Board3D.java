package com.technicat.arcade3d;

import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Board3D extends Canvas3D {

    public Board3D() {
	super(SimpleUniverse.getPreferredConfiguration());
	SimpleUniverse u = new SimpleUniverse(this);
	u.getViewingPlatform().setNominalViewingTransform();
	BranchGroup root = new BranchGroup();

	TransformGroup trans = new TransformGroup();
	trans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	trans.addChild(new ColorCube(0.4));

	/*	AxisAngle4f axisAngle = new AxisAngle4f(0.0f,0.0f,1.0f,(float)Math.PI/2.0f);
	Transform3D axis = new Transform3D();
	Alpha alpha = new Alpha(-1,Alpha.INCREASING_ENABLE,0,0,4000,0,0,0,0,0);
	RotationInterpolator rot = new RotationInterpolator(alpha,trans,axis,0.0f,Math.PI*2.0f);
	rot.setSchedulingBounds(new BoundingSphere(new Point3d(0,0,0),100));
	trans.addChild(rot); */

	root.addChild(trans);
	root.compile();
	u.addBranchGraph(root);

    }
}