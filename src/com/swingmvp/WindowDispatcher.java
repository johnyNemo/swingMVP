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
public interface WindowDispatcher {
    public void dispatch(ServiceContainerInterface serviceContainer); 
    public View getDispatchedView();
}
