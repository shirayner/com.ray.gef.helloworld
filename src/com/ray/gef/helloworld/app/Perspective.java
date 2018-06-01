package com.ray.gef.helloworld.app;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {
	public static final String PERSPECTIVE_ID = "com.ray.gef.helloworld.perspective"; //$NON-NLS-1$

	@Override	
	public void createInitialLayout(IPageLayout layout) {
		
	}
}
