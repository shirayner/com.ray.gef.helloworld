package com.ray.gef.helloworld.part.policy;



import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.ray.gef.helloworld.part.command.ChangeConstraintCommand;

public class CustomerXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command createAddCommand(EditPart child, Object constraint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Command createChangeConstraintCommand(EditPart child,Object constraint) {
		ChangeConstraintCommand command = new ChangeConstraintCommand();
		command.setModel(child.getModel());
		command.setConstaint((Rectangle)constraint);
		return command;
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		/*CreateCommand command = new CreateCommand();
		Rectangle constraint = (Rectangle)getConstraintFor(request);
		HelloModel model = (HelloModel)request.getNewObject();
		model.setConstraint(constraint);
		command.setContentsModel(getHost().getModel());
		command.setHelloModel(model);
		return command;*/
		return null;
	}

	@Override
	protected Command getDeleteDependantCommand(Request request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Command getCommand(Request request){
		System.out.println(request.getType());
		return super.getCommand(request);
		
	}

}
