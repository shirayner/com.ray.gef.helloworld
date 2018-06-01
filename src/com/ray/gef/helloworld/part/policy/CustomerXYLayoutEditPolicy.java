package com.ray.gef.helloworld.part.policy;



import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.ray.gef.helloworld.model.HelloModel;
import com.ray.gef.helloworld.part.command.ChangeConstraintCommand;
import com.ray.gef.helloworld.part.command.CreateCommand;

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
		CreateCommand command = new CreateCommand();
		// 产生创建图形的尺寸和位置
		Rectangle constraint = (Rectangle) getConstraintFor(request);
		
		// 获得新创建的图形
		HelloModel model = (HelloModel) request.getNewObject();
		
		// 为该图形设置前面获得的位置和尺寸
		model.setConstraint(constraint);
		
		// 将新创建的图形添加到模型中，
		// 因为我们在第 2 页的（2）中已经把模型更改和它们的 Editpart 联系起来，
		// 因此， Graphical Editor 中的图形也会发生变化
		command.setContentsModel(getHost().getModel());
		command.setHelloModel(model);
		
		return command;
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
