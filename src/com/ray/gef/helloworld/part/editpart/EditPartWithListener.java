package com.ray.gef.helloworld.part.editpart;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.ray.gef.helloworld.model.AbstractModel;

/**
 * 注册监听器
 * @author shira
 *
 */
public class EditPartWithListener extends AbstractGraphicalEditPart implements
		PropertyChangeListener {

	/**
	 * 注册监听器
	 */
	@Override
	public void activate(){
		super.activate();
		//EditPart将自己注册为监听器
		((AbstractModel)getModel()).addPropertyChangeListener(this);
	}
	
	/**
	 * 删除监听器
	 */
	@Override
	public void deactivate(){
		super.deactivate();
		((AbstractModel)getModel()).removePropertyChangeListener(this);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}
	

}
