
package com.acn.manu.controller;

import com.acn.manu.dto.NewDto;
import com.acn.manu.service.NewService;

/**
 *
 * @author manuela
 */
public class NewController {
    
    NewService service= new NewService();
    NewDto dtoOut;
    boolean result=false;
    
    public NewController(){
        
    }
    
    public boolean login(NewDto dto){
        dtoOut = service.login(dto);
        if( dtoOut.getExist().equals("true")){
            System.out.println("Welcome "+ dtoOut.getFirstName()+ " "+ dtoOut.getLastName());
        }else{
            System.out.println("Utente inesistente!!");
        }
        return result=true;
    }
    
}
