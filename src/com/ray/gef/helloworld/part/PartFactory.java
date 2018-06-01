package com.ray.gef.helloworld.part;


import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.ray.gef.helloworld.model.ContentsModel;
import com.ray.gef.helloworld.model.HelloModel;


public class PartFactory implements EditPartFactory {

	//------------------------------------------------------------------------
	// Abstract methods from EditPartFactory

	public EditPart createEditPart(EditPart context, Object model) {

		//get EditPart for model element
		EditPart part = getPartForElement(model);
		//store model element in EditPart
		part.setModel(model); 
		return part;
	}

	/**
	 * Maps an object to an EditPart. 
	 * @throws RuntimeException if no match was found (programming error)
	 */
	private EditPart getPartForElement(Object modelElement) {
		//根据模型类创建其控制器
		if (modelElement instanceof HelloModel)
			return new HelloEditorPart();
		else if(modelElement instanceof ContentsModel){
			return new ContentsEditorPart();
			
		}

		throw new RuntimeException(
				"Can't create part for model element: "
						+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
	}

}
