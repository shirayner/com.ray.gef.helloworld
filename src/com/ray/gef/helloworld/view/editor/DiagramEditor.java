package com.ray.gef.helloworld.view.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;

import com.ray.gef.helloworld.model.ContentsModel;
import com.ray.gef.helloworld.model.HelloModel;
import com.ray.gef.helloworld.part.factory.PartFactory;

public class DiagramEditor extends GraphicalEditor {
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
}
