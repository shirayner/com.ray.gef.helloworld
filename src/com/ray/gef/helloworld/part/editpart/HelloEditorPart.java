package com.ray.gef.helloworld.part.editpart;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.ray.gef.helloworld.model.HelloModel;



public class HelloEditorPart extends EditPartWithListener {

	/**
	 * 主要是在这个方法中进行作图
	 */
	@Override
	protected IFigure createFigure() {
		HelloModel model = (HelloModel)getModel();

		Label label = new Label();
		label.setText(model.getText());

		label.setBorder(new CompoundBorder(new LineBorder(), new MarginBorder(3)));

		//设置背景颜色
		label.setBackgroundColor(ColorConstants.orange);

		label.setOpaque(true);

		return label;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

	}

	
	/**
	 * GEF在 AbstractEditPart 类中提供此方法用于把约束施加给图形
	 */
	@Override
	public void refreshVisuals(){
		Rectangle constraint = ((HelloModel)getModel()).getConstraint();
		
		((GraphicalEditPart)getParent()).setLayoutConstraint(this,getFigure(),constraint);
		
	}

	/**
	 * 监听模型变化
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getPropertyName().equals(HelloModel.P_CONSTRAINT)){
			refreshVisuals();
		}
	}
	
	
	
}
