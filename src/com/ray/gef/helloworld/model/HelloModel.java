package com.ray.gef.helloworld.model;

import org.eclipse.draw2d.geometry.Rectangle;

public class HelloModel extends AbstractModel{
	
	public static final String P_CONSTRAINT = "_constraint";

	private String text = "Hello World";

	
	/**
	 * 约束：图形在图形集中的位置和大小。
	 */
	private Rectangle constraint;

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



	public Rectangle getConstraint() {
		return constraint;
	}

	public void setConstraint(Rectangle constraint) {
		this.constraint = constraint;
		//属性变更通知
		firePropertyChange(P_CONSTRAINT,null,constraint);
	}




}
