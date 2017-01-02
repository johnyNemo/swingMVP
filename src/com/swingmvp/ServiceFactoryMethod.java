/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp;

import com.swingmvp.dc.ServiceContainerInterface;

/**
 *
 * @author marek
 */
public interface ServiceFactoryMethod {
    public Object create(ServiceContainerInterface serviceContainer);
}
