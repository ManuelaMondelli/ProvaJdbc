package prova14mar;

import com.acn.manu.dto.DTOEmployee;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author manuela.mondelli
 */
public class Controller {

    private Dto dto;
    private int operazione;
    private boolean result;
    private Scanner input;
    private DaoLogin loginDao;

    public Controller() {
        loginDao = new DaoLogin();
        input = new Scanner(System.in);
    }
    
    
    
    /**
     * 
     * @param email 
     * @return  
     */
    public boolean checkLogin(String email){
        
        return loginDao.checkLogin(email);
    }

    //il controller prende il DTO e lo passa al service
    //in base al risultato restituirà un valore boolean VERO o FALSO
    public boolean accesso(Dto dto) {
        System.out.println("LE OPERAZIONI ESEGUIBILI SONO: ");
        System.out.println("1-ANAGRAFICA IMPIEGATO");
        System.out.println("2-STAMPA LISTA IMPIEGATI");
        System.out.println("3-RICERCA IMPIEGATO");
        System.out.println("Quale operazione vuoi effettuare?");
        operazione = input.nextInt();
        if ((operazione < 0) || (operazione > 3)) {
            System.out.println("Operazione non eseguibile!");
        }
        else if (operazione == 1) {
            DaoAnagrafica daoA = new DaoAnagrafica();
            System.out.println("Inserisci l'id dell'impiegato");
            int idE = input.nextInt();
            dto=daoA.anagrafica(idE);
            System.out.println("First Name: " + dto.getFirstName());
            System.out.println("Last Name: " + dto.getLastName());
        }

        if (operazione == 2) {
            System.out.println("1");
            DaoLista daoL = new DaoLista();
            System.out.println("2");
            List<Dto> lista = daoL.lista();
            System.out.println("Gli impiegati presenti nel DB sono: ");
            if (!lista.isEmpty()) {
                for (Dto dtoL : lista) {
                    System.out.println("Gli impiegati presenti nel database sono:" + dtoL.getFirstName());
                    System.out.println(dto.getLastName());
                    System.out.println(dto.getEmail());
                }
            }

            if (operazione == 3) {
                DaoImpiegato daoI = new DaoImpiegato();
                System.out.println("Inserisci l'id dell'impiegato");
                int idE = input.nextInt();
                dto = daoI.impiegato(idE);
                System.out.println("First Name: " + dto.getFirstName());
                System.out.println("Last Name: " + dto.getLastName());
                System.out.println("Manager_ID: " + dto.getManagerId());
                System.out.println("Department_ID: " + dto.getDepartmentId());
            }

        }
        input.close();
        return result;
    }

}
