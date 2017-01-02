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
public interface ServiceContainerInterface {
    public void registerService(String serviceName, ServiceFactoryMethodInterface factoryMethod, boolean cacheInstance);
    
    public <T> T getService(String serviceName);
}
