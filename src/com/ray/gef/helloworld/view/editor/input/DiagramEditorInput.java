package com.ray.gef.helloworld.view.editor.input;



import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IPersistableElement;

public class DiagramEditorInput implements IPathEditorInput {

	private IPath path;

	public DiagramEditorInput(IPath path) {
		this.path = path;
	}

	public IPath getPath() {
		return path;
	}

	public boolean exists() {
		return path.toFile().exists();
	}

	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return path.toString();
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return path.toString();
	}

	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	//add by Bin Wu
	public int hashCode() {
		return path.hashCode();
	}
	
	
	
}
