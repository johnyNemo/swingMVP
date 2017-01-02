
package com.deploymanager.controller;

import com.swingmvp.Application;
import com.swingmvp.Presenter;
import com.swingmvp.View;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marek
 */
public class MainController extends Presenter{
    
    private Application _app;
    
    

    public MainController(Application app,HashMap<String, Observable> presentationModels) {
        super(presentationModels);
        _app = app;
    }

    public void incrementLabelValue() {
        TestModel model = getPresentationModel("test_model");
        
        model.setValue(model.getValue() + 10);
    }
    
    public void showModalWindow(String arg) {
        try {
           View view = _app.openWindowModal("test");
        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
