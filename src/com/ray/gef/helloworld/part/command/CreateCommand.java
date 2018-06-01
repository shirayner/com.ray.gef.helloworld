package com.ray.gef.helloworld.part.command;




import org.eclipse.gef.commands.Command;

import com.ray.gef.helloworld.model.ContentsModel;
import com.ray.gef.helloworld.model.HelloModel;

public class CreateCommand extends Command {

	private ContentsModel contentsModel;
	
	private HelloModel helloModel;
	
	public void execute(){
		contentsModel.addChild(helloModel);
	}
	
	public void setContentsModel(Object model){
		contentsModel = (ContentsModel)model;
	}
	
	public void setHelloModel(Object model){
		helloModel = (HelloModel)model;
	}
	
	public void undo(){
		contentsModel.removeChild(helloModel);
	}
}
