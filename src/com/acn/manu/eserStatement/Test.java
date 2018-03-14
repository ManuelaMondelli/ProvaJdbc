
package com.acn.manu.eserStatement;

import com.acn.manu.eserStatement.Controller;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author manuela
 */


public class Test {

    public static void main(String[] args) {

        Controller controller = new Controller();
        //controller.inserimento(); //funziona
        //controller.findAllEmployees(); //funziona
        //controller.findEmployeeByID(); //funziona
        //controller.delete(); //funziona

        //controller.update(); //funziona
        //controller.updateP(); //funziona
        //controller.createRecord(); //funziona
        //controller.deleteP(); //funziona
        
        //controller.createHistory();
        controller.addCountry();
    }
}
