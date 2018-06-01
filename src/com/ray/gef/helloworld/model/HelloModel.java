package com.ray.gef.helloworld.model;

import org.eclipse.draw2d.geometry.Rectangle;

public class HelloModel {

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
	}




}
