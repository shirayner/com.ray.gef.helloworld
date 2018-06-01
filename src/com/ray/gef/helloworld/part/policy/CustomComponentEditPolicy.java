package com.ray.gef.helloworld.part.policy;




import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.ray.gef.helloworld.part.command.DeleteCommand;

public class CustomComponentEditPolicy extends ComponentEditPolicy {

	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest){
		//调用DeleteCommand
		DeleteCommand deleteCommand = new DeleteCommand();
		deleteCommand.setContentsModel(getHost().getParent().getModel());
		deleteCommand.setHelloModel(getHost().getModel());
		return deleteCommand;
		
	}
}
