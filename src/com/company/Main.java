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
        boolean systemOn = true;
        boolean loggedIn=false;
        int employeeID = 0;

        EmployeeData employeeData = new EmployeeData();
        LoginFacade loginFacade = new LoginFacade();
        EventData eventData = new EventData();
        RequestFacade requestFacade = new RequestFacade();
        EventFacade eventFacade = new EventFacade();

        employeeData.startUp();


       //Loop while not yet logged in
        while(systemOn)
        {
            printBanner();
            System.out.println("Welcome to the Swedish Event Planners system!\n" +
                    "\nPlease log in!");

            while (!loggedIn) {
                employeeID = loginFacade.logIn(employeeData);
                if (employeeID > 0)
                    loggedIn = true;
            }
            Employee user = employeeData.getEmployee(employeeID);
            System.out.println("Welcome " + user.getName());

            printMainMenu();
            showActions(user, eventData, requestFacade, eventFacade,employeeData);
            loggedIn = false;
            //Loop when logged in
            /*while (loggedIn)
            {
                printMainMenu();
                showActions(user, eventData, requestFacade, eventFacade,loggedIn);
                System.out.println("HI " + loggedIn);
                //loginFacade.selectAction(user);
            }*/
        }
    }
    //Display available actions and check access rights, loop while waiting for choice
    private static void showActions(Employee employee,EventData eventData,RequestFacade requestFacade, EventFacade eventFacade, EmployeeData employeeData) {

        Scanner s = new Scanner(System.in);
        //get access rights and print actions
        String[] accessRights = employee.getAccessRights();

        System.out.println("What would you like to do? Please type the action exactly\n");
        printActions(accessRights);
        String input = s.nextLine();
        while (!input.equals("log out"))
        {
            if(checkInput(accessRights, input))
            {
                switch (input)
                {
                    //Event
                    case "view events":
                        eventFacade.viewEvent(employee,employeeData);
                    //if has rights allow update
                        break;
                    //maybe "open event instead"
                    case "create event":
                        eventFacade.createEvent();
                        break;
                    case "update event":
                        eventFacade.updateEvent();
                        break;
                    case "view event requests":
                        requestFacade.viewEventRequest();
                        break;
                    case "create event request":
                        requestFacade.createEventRequest();
                        break;
                        //stores 2x needs fix
                    case "update event request":
                        requestFacade.updateEventRequest();
                        break;
                    case "approve event request":
                        if(employee.getEmployeeType().equals("CSManager"))
                            requestFacade.approveEventRequestCSManager();
                        else if(employee.isAdmin())
                            requestFacade.approveEventRequestAdmin();
                        break;
                     //not implemented yet
                    case "create financial request":
                        requestFacade.createFinancialRequest();
                        break;
                    case "create HR request":
                        requestFacade.createHRRequest();
                        break;

                    case "view employees":
                        System.out.println("Not yet implemented");
                 }
            }
            else {
                System.out.println("Not a recognized command");
            }
            System.out.println("What would you like to do? Please type the action exactly\n");
            printActions(accessRights);
            input = s.nextLine();
        }
    }
    private static void printActions(String[] accessRights)
    {
        for (int i = 0; i < accessRights.length; i++) {
            System.out.print(accessRights[i] + ", ");
            //This breaks up the list so it is easier to view
            if(i%5 == 4)
            {
                System.out.println();
            }
        }
        System.out.println("log out");
    }
    //return true if user has access right
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
