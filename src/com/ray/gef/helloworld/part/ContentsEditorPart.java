package com.ray.gef.helloworld.part;


import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.ray.gef.helloworld.model.ContentsModel;


public class ContentsEditorPart extends AbstractGraphicalEditPart {

	protected IFigure createFigure() {
		//给图形集设置一个透明图层（Layer）
		Layer figure = new Layer();
		figure.setLayoutManager(new XYLayout());
		return figure;
	}

	protected void createEditPolicies() {
				
	}
	
	protected List getModelChildren(){
		
		return ((ContentsModel)getModel()).getChildren();
	}
}
