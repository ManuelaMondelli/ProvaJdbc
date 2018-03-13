/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu.service;
import com.acn.manu.dao.DAOLoginImpl;
import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.dto.DTOLogin;

/**
 *
 * @author manuela
 */
public class ServiceLogin {

     DAOLoginImpl daoLoginImpl = new DAOLoginImpl();
     boolean result = false;
     
    public void verifyCredentialLogin() {
       DTOEmployee dtoEmp = daoLoginImpl.retriveCredentials(); 
       
    }
    
    
    //Prende il DTO e chiama il metodo del DAO passandogli i dati presenti nel DTO
    //Al ritorno dal DAO esegue la logica di Business
}
