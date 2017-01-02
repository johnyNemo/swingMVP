/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;

/**
 *
 * @author marek
 */
public abstract class Presenter {

    private HashMap<String, Observable> _presentationModels;
    
    public Presenter(HashMap<String, Observable> presentationModels) {
        _presentationModels = presentationModels;
    }
    
    protected <T extends Observable> T getPresentationModel(String modelName) {
        return (T) _presentationModels.get(modelName);
    }
    
    public Collection<Observable> getPresentationModels() {
        return _presentationModels.values();
    }
    
}
