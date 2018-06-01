package com.ray.gef.helloworld.part.command;



import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.ray.gef.helloworld.model.HelloModel;

public class ChangeConstraintCommand extends Command {

	private HelloModel helloModel;
	private Rectangle constraint;
	private Rectangle oldCons;




	@Override
	public void execute(){
		helloModel.setConstraint(constraint);
	}



	@Override
	public void undo(){
		helloModel.setConstraint(oldCons);

	}

	public void setConstaint(Rectangle rect){
		constraint = rect;
	}


	public void setModel(Object model){
		helloModel = (HelloModel)model;
		oldCons = helloModel.getConstraint();		
	}
}
