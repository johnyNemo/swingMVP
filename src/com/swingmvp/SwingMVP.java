/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp;

import com.deploymanager.controller.MainController;
import com.deploymanager.controller.TestModel;
import com.deploymanager.gui.MainView;
import com.deploymanager.gui.TestView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

/**
 *
 * @author marek
 */
public class SwingMVP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceContainer sc = new ServiceContainer();
        Application app = new Application(sc);
        
        sc.registerService("MainController", (ServiceContainerInterface serviceContainer) -> {
            HashMap<String, Observable> models = new HashMap<>();
            models.put("test_model", new TestModel());
            return new MainController(app,models);
        }, true);
        
        sc.registerService("main", (ServiceContainerInterface serviceContainer) -> {
            return new MainView(serviceContainer.getService("MainController"));
        }, false);
        
        sc.registerService("test", (ServiceContainerInterface serviceContainer) -> {
            return new TestView(serviceContainer.getService("MainController"));
        }, false);
        
        
        
        app.openWindow("main");     
        
        
    }
}
