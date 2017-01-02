/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp.config;

import java.util.HashMap;

/**
 *
 * @author marek
 */
public class Configuration {
    
    private HashMap<String, ViewConfiguration> _viewPresenter = new HashMap<>();
    
    public ViewConfiguration getViewConfiguration(String viewName)
    {
        return _viewPresenter.get(viewName);
    }

    void addViewConfiguration(String viewName, String presenterName) {
        _viewPresenter.put(viewName, new ViewConfiguration(viewName,presenterName));
    }
    
}
