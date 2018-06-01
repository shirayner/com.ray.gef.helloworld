package com.ray.gef.helloworld.part.editpart;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;

import com.ray.gef.helloworld.model.HelloModel;
import com.ray.gef.helloworld.part.policy.CustomComponentEditPolicy;



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

		//安装Policy
		//参数一：指定 EditPolicy的角色，设置这个变量是因为：一个EditPart 可以安装很多 EditPolicy，如果他们的角色都相同，就是这个字符串参数相同，
		//那么只有最后安装的一个 policy 是有效的。
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new CustomComponentEditPolicy());

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
		//EditPart监听到模型改变
		if(event.getPropertyName().equals(HelloModel.P_CONSTRAINT)){
			refreshVisuals();
		}
	}



}
