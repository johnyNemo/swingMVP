
package com.swingmvp;

import com.swingmvp.dc.ServiceContainerInterface;


/**
 *
 * @author marek
 */
public abstract class Presenter {
    
    private Application _application;
    
    public Presenter(Application application) {
        _application = application;
    }
    
    protected ServiceContainerInterface getContainer() {
        return _application.getServiceContainer();
    }
    
    protected void openWindow(String viewName) {
        _application.openWindow(viewName);
    }
    
    abstract protected void setView(View v);
    
}
