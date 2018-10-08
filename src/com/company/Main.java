/*
 * Initial driver class to test code
 */
package com.company;

import com.company.Event.EventData;
import com.company.Event.EventFacade;
import com.company.RequestSub.RequestFacade;
import com.company.WorkerSub.Employee;
import com.company.WorkerSub.EmployeeData;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        //Login
        boolean loggedIn=false;
        int employeeID = 0;

        EmployeeData employeeData = new EmployeeData();
        LoginFacade loginFacade = new LoginFacade();
        EventData eventData = new EventData();
        RequestFacade requestFacade = new RequestFacade();
        EventFacade eventFacade = new EventFacade();

        employeeData.startUp();

        printBanner();
        System.out.println("Welcome to the Swedish Event Planners system!\n" +
                "\nPlease log in!");

       //Loop while not yet logged in
        while(!loggedIn)
        {
            employeeID = loginFacade.logIn(employeeData);
            if(employeeID>0)
                loggedIn=true;
        }
        //Get user details
        Employee user = employeeData.getEmployee(employeeID);
        String[] accessRights = employeeData.getAccessRights(user);

        printMainMenu();
        System.out.println("Welcome " + user.getName());

        //Loop when logged in
        while(loggedIn)
        {
            showActions(user,eventData,requestFacade,eventFacade);
            //loginFacade.selectAction(user);

        }
    }
    //Display available actions and check acces rights, loop while waiting for choice
    private static void showActions(Employee employee,EventData eventData,RequestFacade requestFacade, EventFacade eventFacade) {

        Scanner s = new Scanner(System.in);
        System.out.println("What would you like to do? Please type the action in parentheses");

        //get access rights and print actions
        String[] accessRights = employee.getAccessRights();
        for (int i = 0; i < accessRights.length; i++) {
            System.out.println(accessRights[i]);
        }
        //let user access function if accessRights check out
        String input = s.nextLine();
        while (!input.equals("back")) {

            //handle every action
            if (checkInput(accessRights, input)) {
            switch (input) {
                    //Event
                case "view events":
                    eventFacade.showEvents();
                    //if has rights allow update
                    input="back";
                    break;
                    //maybe "open event instead"
                case "create event":
                    eventFacade.createEvent();
                    input="back";
                    break;
                case "update event":
                    eventFacade.updateEvent();
                    input="back";
                    break;
                    //not implemented yet
                case "create task":
                    requestFacade.createEventRequest();
                    input="back";
                    break;
                    //Requests
                case "view event requests":
                    requestFacade.viewEventRequest();
                    input="back";
                    break;
                case "create event request":
                    requestFacade.createEventRequest();
                    input="back";
                    break;
                    //stores 2x needs fix
                case "update event request":
                    requestFacade.updateEventRequest();
                    input="back";
                    break;
                    //not implemented yet
                case "create financial request":
                    requestFacade.createFinancialRequest();
                    input="back";
                    break;
                case "create HR request":
                    requestFacade.createHRRequest();
                    input="back";
                    break;

            }
            }
            else{
                System.out.println("Nor a recognized command");
                input="back";
                break;
            }
        }
        //goes back to
        printMainMenu();
    }
    //return true if user has accessright
    private static boolean checkInput(String[] accessRights,String input){
        for(int i=0;i<accessRights.length;i++) {
            if(accessRights[i].equals(input)){
                return true;
            }
        }
        return false;
    }
    private static void printBanner(){
        System.out.println(" __________________________________________");
        System.out.println("|          SWEDISH EVENT PLANNERS          |");
        System.out.println(" ------------------------------------------");
    }
    private static void printMainMenu(){
        System.out.println(" _________________________________________");
        System.out.println("|                MAIN MENU                |");
        System.out.println(" -----------------------------------------");
    }

}
