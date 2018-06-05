package com.ray.gef.helloworld.part.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import com.ray.gef.helloworld.model.HelloModel;

public class HelloFigure extends Figure {

	HelloModel model;

	public HelloFigure(HelloModel model) {
		super();
		this.model = model;
	}


	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);

		//一、填充图形
		
		//获取作图区域
		Rectangle rect = getBounds();

		//1.设置背景颜色
		setBackgroundColor(ColorConstants.orange);
		graphics.fillRectangle(rect.x, rect.y, rect.width, rect.height);

		
		//2.设置文本
		graphics.drawString(model.getText(),rect.x + 2, rect.y+ 2);


	}


	public HelloModel getModel() {
		return model;
	}

	public void setModel(HelloModel model) {
		this.model = model;
	}




}
