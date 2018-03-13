/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.controller;

import com.acn.manu.dto.DTOLogin;
import com.acn.manu.service.ServiceLogin;

/**
 *
 * @author manuela
 */
public class ManagerController {
    
    ServiceLogin serviceLogin = new ServiceLogin();
    boolean result = false;

    public ManagerController() {
    }

    
    
    /**
     * 
     * @param dtoLogin 
     */
    public void checkLogin() {
         serviceLogin.verifyCredentialLogin();
         
    }
    
    
    //Espone un metodo che prende in input il DTO 
    // restituisce ok o OK in base al risultato del service
    
}
