package com.ray.gef.helloworld.part.command;



import org.eclipse.gef.commands.Command;

import com.ray.gef.helloworld.model.ContentsModel;
import com.ray.gef.helloworld.model.HelloModel;

public class DeleteCommand extends Command {
	
	
	private ContentsModel contentsModel;
	
	private HelloModel helloModel;
	
	@Override
	public void execute(){
		
		//删除模型
		contentsModel.removeChild(helloModel);
	}
	
	@Override
	public void undo(){
		contentsModel.addChild(helloModel);
	}
	
	public void setContentsModel(Object model){
		contentsModel = (ContentsModel)model;
	}

	public void setHelloModel(Object model){
		helloModel = (HelloModel)model;
	}
	

}
