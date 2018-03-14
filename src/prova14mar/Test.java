package prova14mar;

import java.util.Scanner;

/**
 *
 * @author manuela.mondelli
 */
public class Test {

    private static Dto dto;
    private static Controller controller ;

    public static void main(String[] args) {
        dto = new Dto();
        controller = new Controller();
        //inserimento della mail
        //verifica di nullità
        //chiamata al controller
        Scanner input = new Scanner(System.in);
        System.out.println("ACCESSO");
        System.out.println("Inserisci la tua mail");
        String mail = input.next();
        if (mail != null) {
            //setting DTO input con il valore della mail
            dto.setEmail(mail);
            if ( controller.checkLogin(dto.getEmail())){
                controller.accesso(dto);
                System.out.println("Accesso effettuato!");
            }else{
                System.out.println("Accesso Errato!!");                
            }
        } else {
            System.out.println("Email inesistente!");
        }
        input.close();
    }

}
