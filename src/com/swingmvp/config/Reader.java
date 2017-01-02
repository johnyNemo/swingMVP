/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingmvp.config;

/**
 *
 * @author marek
 */
public interface Reader {
    public Configuration read(String fileName);
}
