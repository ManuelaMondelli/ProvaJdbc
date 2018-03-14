package com.acn.manu.eserStatement;

import com.acn.manu.dto.DTOEmployee;
import com.acn.manu.eserStatement.callablestatement.CreateCS;
import com.acn.manu.eserStatement.callablestatement.Eser;
import com.acn.manu.eserStatement.preparestatement.CreatePS;
import com.acn.manu.eserStatement.preparestatement.DeletePS;
import com.acn.manu.eserStatement.statement.Create;
import com.acn.manu.eserStatement.preparestatement.RetrievePS;
import com.acn.manu.eserStatement.preparestatement.UpdatePS;
import com.acn.manu.eserStatement.statement.Delete;
import com.acn.manu.eserStatement.statement.Retrieve;
import com.acn.manu.eserStatement.statement.Update;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuela
 */
public class Controller {

    private Create create;
    private Retrieve retrieve;
    private Retrieve pstm;
    private Delete delete;
    private RetrievePS retrievePS;
    private Update update;
    private UpdatePS updateps;
    private CreatePS createps;
    private DeletePS deleteps;
    private CreateCS createcs;
    private Eser eser;

    public Controller() {
        create = new Create();
        retrieve = new Retrieve();
        pstm = new Retrieve();
        delete = new Delete();
        retrievePS = new RetrievePS();
        update = new Update();
        updateps = new UpdatePS();
        createps = new CreatePS();
        deleteps = new DeletePS();
        createcs=new CreateCS();
        eser=new Eser();
    }

    //STATEMENT
    //CREATE nuovo record (Statement)
    public void inserimento() {
        System.out.println("Inserimento nuovo record");
        create.create();
        
        
    }

    //RETRIEVE lista degli impiegati (funzionante)
    public void findAllEmployees() {
        List<DTOEmployee> listEmp = retrieve.findAll();
        if (!listEmp.isEmpty()) {
            for (DTOEmployee dTOEmployee : listEmp) {
                System.out.println("1-Gli impiegati presenti nel database sono:" + dTOEmployee.getEmail());
            }
        }
//        for (int i = 0; i < listEmp.size(); i++) {
//            System.out.println("2-Gli impiegati presenti nel database sono:" + listEmp.get(i).getEmail());
//        }
    }

    //UPDATE nome impiegato tramite ID
    public void update() {
        try {
            int row = update.aggiorna();
            System.out.println("Sono state aggiornate " + row + "righe");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //DELETE record impiegato tramite ID
    public void delete() {
        int row = delete.deleteRecord();
        System.out.println("L'aggiornamento è stato effettuato " + row);
    }

    //PREPARE STATEMENT
    //CREATE nuovo record
    public void createRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("INSERIMENTO NUOVO IMPIEGATO");
        System.out.println("Inserire EMPLOYEE_ID");
        int idE = input.nextInt();
        System.out.println("Inserire FIRST_NAME");
        String name = input.next();
        System.out.println("Inserire LAST_NAME");
        String surname = input.next();
        System.out.println("Inserire EMAIL");
        String email = input.next();
        System.out.println("Inserire PHONE_NUMBER");
        String phone = input.next();
        System.out.println("Inserire HIRE_DATE");
        String data = input.next();
        System.out.println("Inserire JOB_ID");
        String idJob = input.next();
        System.out.println("Inserire SALARY");
        double salary = input.nextDouble();
        System.out.println("Inserire COMMISSION_PCT");
        double commission = input.nextDouble();
        System.out.println("Inserire MANAGER_ID");
        int idManager = input.nextInt();
        System.out.println("Inserire DEPARTMENT_ID");
        int idDepartment = input.nextInt();
        Dto dto = new Dto(idE, name, surname, email, phone, data, idJob, salary, commission, idManager, idDepartment);
        createps.created(dto);
        System.out.println("Il nuovo record inserito è: " + dto.getEmployeeId());
        System.out.println("Il nuovo record inserito è: " + dto.getFirstName());
        System.out.println("Il nuovo record inserito è: " + dto.getLastName());
        System.out.println("Il nuovo record inserito è: " + dto.getEmail());
        System.out.println("Il nuovo record inserito è: " + dto.getPhoneNumber());
        System.out.println("Il nuovo record inserito è: " + dto.getHireDate());
        System.out.println("Il nuovo record inserito è: " + dto.getJobId());
        System.out.println("Il nuovo record inserito è: " + dto.getSalary());
        System.out.println("Il nuovo record inserito è: " + dto.getCommissionPct());
        System.out.println("Il nuovo record inserito è: " + dto.getManagerId());
        System.out.println("Il nuovo record inserito è: " + dto.getDepartmentId());

    }

    //RETRIEVE impiegato tramite ID input (funzionante)
    public void findEmployeeByID() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Inserisci l'ID dell'impiegto che vuoi cercare");
            int idE = input.nextInt();
            Dto dto = retrievePS.findID(idE);
            if (dto.getResultSql() > 0) {
                System.out.println("First: " + dto.getFirstName());
                System.out.println("First: " + dto.getLastName());
                System.out.println("First: " + dto.getEmail());
            } else {
                System.out.println("Nessun elemento trovato!");

            }
            input.close();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //UPDATE impiegato tramite ID
    public void updateP() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("MODIFICA COMMISSIONI");
            System.out.println("\rInserisci l'ID dell'impiegto");
            int idE = input.nextInt();
            Boolean esito = updateps.update(idE);
            System.out.println("Operazione OK: "+esito);
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //DELETE tramite id da input
    public void deleteP() {
        Scanner input = new Scanner(System.in);
        System.out.println("ELIMINAZIONE RECORD" + "\rInserisci l'ID dell'impiegto");
        int idE = input.nextInt();
        int row = deleteps.deleted(idE);
        System.out.println("Sono state eliminate" + row + "righe");
    }

    //CALLABLE STATEMENT
    //CREATE
    public void createHistory(){
        Scanner input=new Scanner(System.in);
        System.out.println("JOB HISTORY");
        System.out.println("Inserire EMPLOYEE_ID");
        int idE = input.nextInt();
        System.out.println("Inserire START_DATE");
        String sd=input.next();
        System.out.println("Inserire END_DATE");
        String ed=input.next();
        System.out.println("Inserire JOB_ID");
        String idJob = input.next();
        System.out.println("Inserire DEPARTMENT_ID");
        int idDepartment = input.nextInt();
        int n=createcs.create(idE, sd, ed, idE, idDepartment);
        System.out.println("Procedura eseguita");
    }
    
    public void addCountry(){
        Scanner input=new Scanner(System.in);
        System.out.println("PROCEDURA ADD_COUNTRY");
        System.out.println("Inserire REGION_ID");
        int idRegion = input.nextInt();
        eser.country(idRegion);
        System.out.println("Procedura eseguita");
    }
}
