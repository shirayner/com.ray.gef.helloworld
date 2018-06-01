package com.ray.gef.helloworld.action;


import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ray.gef.helloworld.app.Application;
import com.ray.gef.helloworld.constant.IImageConstant;
import com.ray.gef.helloworld.view.editor.DiagramEditor;
import com.ray.gef.helloworld.view.editor.input.DiagramEditorInput;

public class DiagramAction extends Action implements ISelectionListener,
		IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "com.ray.gef.helloworld.action.DiagramAction";
	private IStructuredSelection selection;

	public DiagramAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Diagram");
		setToolTipText("Draw the GEF diagram.");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				Application.PLUGIN_ID, IImageConstant.EDITORTITLE));
		window.getSelectionService().addSelectionListener(this);
	}

	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		String path = openFileDialog();
		if (path != null) {
			IEditorInput input = new DiagramEditorInput(new Path(path));
			IWorkbenchPage page = window.getActivePage();
			try {
				page.openEditor(input,DiagramEditor.EDITOR_ID,true);
			} catch (PartInitException e) {
				// handle error
			}
		}
	}

	private String openFileDialog() {
		FileDialog dialog = new FileDialog(window.getShell(), SWT.OPEN);
		dialog.setText("??");
		dialog.setFilterExtensions(new String[] { ".diagram" });
		return dialog.open();
	}
}
