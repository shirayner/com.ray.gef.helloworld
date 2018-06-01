package com.ray.gef.helloworld.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

public class AbstractModel implements IPropertySource{

	private  PropertyChangeSupport listeners = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener l) {
        listeners.addPropertyChangeListener(l);
    }

    protected void firePropertyChange(String prop, Object old, Object newValue) {
        listeners.firePropertyChange(prop, old, newValue);
    }

   public void removePropertyChangeListener(PropertyChangeListener l){
	   listeners.removePropertyChangeListener(l);
   }

public Object getEditableValue() {
	// TODO Auto-generated method stub
	return null;
}

public IPropertyDescriptor[] getPropertyDescriptors() {
	// TODO Auto-generated method stub
	return new IPropertyDescriptor[0];
}

public Object getPropertyValue(Object id) {
	// TODO Auto-generated method stub
	return null;
}

public boolean isPropertySet(Object id) {
	// TODO Auto-generated method stub
	return false;
}

public void resetPropertyValue(Object id) {
	// TODO Auto-generated method stub
	
}

public void setPropertyValue(Object id, Object value) {
	// TODO Auto-generated method stub
	
}
   
}
