package com.ray.gef.helloworld.part.figure;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

import com.ray.gef.helloworld.constant.IImageConstant;
import com.ray.gef.helloworld.model.HelloModel;
import com.ray.gef.helloworld.util.ImageCacheHelper;

public class HelloFigure extends Figure {
	
	private static final Image ICON_ADD1 = ImageCacheHelper.getINSTANCE().getImage(IImageConstant.TEST_IMG_ADD);   
	HelloModel model;

	public HelloFigure(HelloModel model) {
		super();
		this.model = model;
	}


	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);

		//一、填充图形
		
		//
		/** 获取作图区域:
		 * 1.getBounds() :
		 *     返回完全包围图形的最小矩形。实现者可以通过引用返回矩形。
		 *     因此，此方法的调用者不能修改返回的矩形。
		 * 2.getCopy() :
		 *     返回一个与此矩形具有完全相同参数的新矩形。
		 */
		Rectangle rect = getBounds().getCopy();

		//1.设置背景颜色
		setBackgroundColor(ColorConstants.orange);
		graphics.fillRectangle(rect.x, rect.y, rect.width, rect.height);

		
		//2.设置文本
		graphics.drawString(model.getText(),rect.x + 2, rect.y+ 2);

		//3.设置图标
		//3.1 方式1 ok
/*		Point targetPoit = new Point();
		targetPoit.x = rect.x + 15 ;
		targetPoit.y = rect.y  + 40;
		graphics.drawImage(ICON_ADD1, targetPoit);
		
*/		
		
		//3.2 
		Rectangle srcRect =new Rectangle(0,0,14,14);  //要保证图标的宽高要合理
		Rectangle destRect = new Rectangle(rect.x +10,
				rect.y  + 30, 
				20, 
				20);
		graphics.drawImage(ICON_ADD1, srcRect, destRect);
		


	}


	public HelloModel getModel() {
		return model;
	}

	public void setModel(HelloModel model) {
		this.model = model;
	}




}
