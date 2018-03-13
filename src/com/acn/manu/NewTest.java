package com.acn.manu;

import com.acn.manu.controller.NewController;
import com.acn.manu.dto.NewDto;
import java.util.Scanner;

/**
 *
 * @author manuela
 */
public class NewTest {

    public static void main(String[] args) {
        Scanner input = null;
        try{
            input = new Scanner(System.in);
            System.out.println("Inserisci username");
            String user = input.next();
            System.out.println("Inserisci password");
            String password = input.next();
            
            System.out.println("User: "+user+ " Pwd: "+ password);
            //Verifica nullità
            if ((user != null) && (password != null)) {
                    //Riempio il DTO con i dati di input    
                    NewDto dto = new NewDto();
                    dto.setUsername(user);
                    dto.setPassword(password);
                    NewController controller = new NewController();
                    controller.login(dto);            
            }
        }catch(Exception e){
            e.getMessage();
        }finally{
            if( input != null)
                    input.close();
        }
}
}

