/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.manu;

import com.acn.manu.controller.ManagerController;
import com.acn.manu.dto.DTOLogin;
import java.util.Scanner;

/**
 *
 * @author manuela
 */
public class Test {
    
    public static void main(String[] args){
   
        //Prendi i dati dello scanner
        //Fai una verifica di nullità sui campi
        //Se OK riempi il relativo DTO
        //else ritenta
        //Chiami il ControllerManager passandogli il DTO
        
        String user = "pp";
        String pwd = "pp";
        DTOLogin dtoLogin ;
        ManagerController mc;
                
          mc = new ManagerController();
           mc.checkLogin();      
                
        
        
    }
    
}
