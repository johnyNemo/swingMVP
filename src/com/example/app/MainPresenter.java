/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.app;

import com.swingmvp.Application;
import com.swingmvp.Presenter;
import com.swingmvp.View;

/**
 *
 * @author marek
 */
public class MainPresenter extends Presenter{
    
    private MainView _view;
    
    public MainPresenter(Application app) {
        super(app);
    }

    @Override
    protected void setView(View v) {
       _view = (MainView) v;
    }
    
}
