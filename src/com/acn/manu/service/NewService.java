
package com.acn.manu.service;

import com.acn.manu.dao.NewDao;
import com.acn.manu.dto.NewDto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class NewService {
    
    NewDao dao=new NewDao();
    NewDto dtoOut;
    boolean result=false;
    
    public NewDto login(NewDto dto){
        try {
            dtoOut = dao.retrieve(dto);
        } catch (SQLException ex) {
            Logger.getLogger(NewService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtoOut;
     }
  
}
