/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp;

/**
 *
 * @author marek
 */
public interface View {
    public void setPresenter(Presenter presenter);
    
    public void show();
    
    public void showModal();
}
