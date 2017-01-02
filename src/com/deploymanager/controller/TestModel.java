/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deploymanager.controller;

import java.util.Observable;

/**
 *
 * @author marek
 */
public class TestModel extends Observable {
    
    private Integer value;
    
    public TestModel(Integer testValue) {
        value = testValue;
    }

    public TestModel() {
       
    }
    
    public Integer getValue()
    {
        return value;
    }
    
    public void setValue(Integer val)
    {
        value = val;
        this.setChanged();
        this.notifyObservers(val);
    }

    
    
    
}
