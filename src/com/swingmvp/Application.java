package com.swingmvp;

import com.deploymanager.gui.MainView;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author marek
 */
public class Application {

    private ServiceContainerInterface _serviceContainer;
    
    private View _view;

    public Application(ServiceContainerInterface serviceContainer) {
        _serviceContainer = serviceContainer;
    }

    public void openWindow(String viewName) {
        java.awt.EventQueue.invokeLater(() -> {
            WindowDispatcher dispatcher = getWindowDispatcher(viewName);
            dispatcher.dispatch(_serviceContainer);
        });
    }

    public View openWindowModal(String viewName) throws InterruptedException, InvocationTargetException {
        
        java.awt.EventQueue.invokeAndWait(() -> {
            WindowDispatcher dispatcher = getWindowDispatcher(viewName);
            dispatcher.dispatch(_serviceContainer);
            _view = dispatcher.getDispatchedView();
        });

        return _view;
    }

    private WindowDispatcher getWindowDispatcher(String viewName) {
        String dispatcherName = "dispatcher_" + viewName + "_dispatcher";

        WindowDispatcher dispatcher = _serviceContainer.getService(dispatcherName);
        if (dispatcher == null) {
            View view = _serviceContainer.getService(viewName);
            dispatcher = new StandardWindowDispatcher(view);
        }
        
        return dispatcher;
    }

    public void registerWindowDispatcher(String viewName, WindowDispatcher dispatcher) {
        _serviceContainer.registerService("dispatcher_" + viewName + "_dispatcher", (ServiceContainerInterface serviceContainer) -> {
            return dispatcher;
        }, true);
    }

    public ServiceContainerInterface getServiceContainer() {
        return _serviceContainer;
    }

}
