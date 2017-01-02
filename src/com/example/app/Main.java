
package com.example.app;

import com.swingmvp.Application;
import com.swingmvp.ServiceFactoryMethod;
import com.swingmvp.dc.ServiceContainerInterface;

/**
 *
 * @author marek
 */
public class Main {
    public static void main(String[] args)
    {
        Application app = Application.init();
        
        app.getServiceContainer().registerService("test-view", (ServiceContainerInterface serviceContainer) -> {
            return new MainView();
        });
        
        app.getServiceContainer().registerService("test-presenter", (ServiceContainerInterface serviceContainer) -> {
            return new MainPresenter(serviceContainer.getService("smvp-application"));
        });
        
        app.openWindow("test-view");
    }
}
