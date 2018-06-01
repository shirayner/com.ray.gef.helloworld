package com.ray.gef.helloworld.view.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ray.gef.helloworld.app.Application;
import com.ray.gef.helloworld.model.ContentsModel;
import com.ray.gef.helloworld.model.HelloModel;
import com.ray.gef.helloworld.part.PartFactory;


public class DiagramEditor extends GraphicalEditorWithPalette  {
	public static final String EDITOR_ID = "com.ray.gef.helloworld.view.editor.DiagramEditor";
	GraphicalViewer viewer;

	public DiagramEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}

	@Override
	protected void configureGraphicalViewer(){

		super.configureGraphicalViewer();
		viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new PartFactory());


	}

	@Override
	protected void initializeGraphicalViewer() {
		// TODO Auto-generated method stub
		ContentsModel parent = new ContentsModel();

		HelloModel child1 = new HelloModel();
		child1.setConstraint(new Rectangle(0,0,-1,-1));
		parent.addChild(child1);

		HelloModel child2 = new HelloModel();
		child2.setConstraint(new Rectangle(30,30,-1,-1));
		parent.addChild(child2);

		HelloModel child3 = new HelloModel();
		child3.setConstraint(new Rectangle(100,80,80,50));
		parent.addChild(child3);

		viewer.setContents(parent);
	}


	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		//在 Palette 中添加工具箱
		//1.创建一个 Palette的root
		PaletteRoot root = new PaletteRoot();

		//2.创建一个工具组用来放置常规Tool
		PaletteGroup toolGroup = new PaletteGroup("Tool");

		//3.创建一个GEF提供的Selection工具并将其放到ToolGroup中
		ToolEntry tool = new SelectionToolEntry();
		toolGroup.add(tool);
		root.setDefaultEntry(tool); //设置该工具是缺省被选择的工具

		//4.创建一个GEF提供的“Marquee多选”工具并将其放到toolGroup中
		tool = new MarqueeToolEntry();
		toolGroup.add(tool);

		//5.创建一个Drawer（抽屉）放置绘图工具，该抽屉名称为“画图”
		PaletteDrawer drawer = new PaletteDrawer("Figure");
		// 指定”创建HelloModel模型”工具所对应的图标
		ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID,"/gar.ico");

		//6.创建”创建HelloModel模型”工具
		CreationToolEntry creationEntry =
				new CreationToolEntry(
						"绘制HelloModel", // The character string displayed on a palette
						"创建HelloModel模型", // Tool 提示
						new SimpleFactory(HelloModel.class), // The factory which creates
						imageDescriptor, // The image of 16X16 displayed on a palette
						imageDescriptor);// The image of 24X24 displayed on a palette
		drawer.add(creationEntry); // （7）将其加到前面创建的抽屉中

		
		//8.最后将创建的两组工具加到root上.
		root.add(toolGroup);
		root.add(drawer);


		return root;
	}
}
