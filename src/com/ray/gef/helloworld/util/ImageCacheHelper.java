package com.ray.gef.helloworld.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ray.gef.helloworld.app.Application;

public class ImageCacheHelper {
	private final Map<String, Image> imageMap = new HashMap<String, Image>();

	private static ImageCacheHelper INSTANCE;

	private ImageCacheHelper() {
	}

	// 单例模式，获得CacheImage实例
	public static ImageCacheHelper getINSTANCE() {
		if (INSTANCE == null)
			INSTANCE = new ImageCacheHelper();
		return INSTANCE;
	}

	// 获得图像
	public Image getImage(String applicationID,String imageName) {
		if (imageName == null)
			return null;
		Image image = (Image) imageMap.get(imageName);
		if (image == null) {
			image =AbstractUIPlugin.imageDescriptorFromPlugin(
					applicationID,imageName).createImage();
			imageMap.put(imageName, image);
		}
		return image;
	}

	// 获得图像
	public Image getImage(String imageName) {
		return getImage( Application.PLUGIN_ID, imageName);
	}
	
	
	// 释放图像资源
	public void dispose() {
		Iterator iterator = imageMap.values().iterator();
		while (iterator.hasNext())
			((Image) iterator.next()).dispose();
		imageMap.clear();
	}
}