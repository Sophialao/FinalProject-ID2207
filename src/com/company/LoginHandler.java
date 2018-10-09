package com.company;

import com.company.WorkerSub.EmployeeData;

import java.util.Scanner;

public class LoginHandler {

    public int logIn(EmployeeData employeeData)
    {
        System.out.print("UserName: ");
        Scanner s = new Scanner(System.in);
        String userName = s.nextLine();
        System.out.print("Password: ");
        String password = s.nextLine();

        //System.out.println("UserName: "+userName +" password: "+password);

        return checkLogIn(userName,password,employeeData);
    }
    /**
     * Checks the userName and password given, and if valid returns the corresponding employee ID.
     * Otherwise 0 is returned
     * @param userName
     * @param password
     * @return
     */
    public int checkLogIn(String userName,String password,EmployeeData employeeData)
    {
        //Checks what the passcode in the database is for a userName with the
        //white space at the end trimmed off
        String passInDataBase = employeeData.getEmployeeCredentials(userName.trim());
        if(passInDataBase == null || !passInDataBase.equals(password.trim()))
        {
            System.out.println("Log in unsuccessful, please try again ");
            return 0;
        }
        System.out.println("Log in successful");
        //fix this
        return employeeData.getEmployeeID(userName.trim());
    }

/*
    public void selectAction(){
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        System.out.println("Action " + choice + " selected");
        if(choice.equals("back")){
            return;
        }
        if(choice.equals("view clients")){
            viewClients();
        }
        if(choice.equals("view clients")){
            viewClients();
        }
    }
    public void viewClients(){
        System.out.println("list of clients");
        System.out.println("Client 1");
        System.out.println("Client 2");
        System.out.println("Client 3");
    }*/
}
