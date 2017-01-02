/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp.dc;

import com.swingmvp.ServiceFactoryMethod;

/**
 *
 * @author marek
 */
public interface ServiceContainerInterface {
    public void registerService(String serviceName, ServiceFactoryMethod factoryMethod, boolean cacheInstance);
    public void registerService(String serviceName, ServiceFactoryMethod factoryMethod);
    public <T> T getService(String serviceName);
}
