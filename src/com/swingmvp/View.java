/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author marek
 */
public interface View extends Observer {
    
    public void observePresenterModel();
    
    public void show();
    
    public void hide();
    
    public void displaySubView(View subView);
}
