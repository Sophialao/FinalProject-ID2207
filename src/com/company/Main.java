/*
 * Initial driver class to test code
 */
package com.company;

import com.company.Event.Event;
import com.company.Event.EventData;
import com.company.Event.EventFacade;
import com.company.RequestSub.RequestFacade;
import com.company.TaskSub.TaskFacade;
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
        TaskFacade taskFacade = new TaskFacade();

        // fake db
        employeeData.startUp();
        requestFacade.startUp();
        eventFacade.startUp();

        Employee empl=employeeData.getEmployee(6);
        Event testEvent = eventFacade.getEvent("TestEvent");
        taskFacade.startUp(empl,testEvent);


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
            showActions(user,eventData, taskFacade,requestFacade, eventFacade,employeeData);
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
    private static void showActions(Employee employee,EventData eventData,TaskFacade taskFacade,RequestFacade requestFacade, EventFacade eventFacade, EmployeeData employeeData) {

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
                    case "create event":
                        requestFacade.showEventRequests();
                        System.out.println("Input name of request you want to use to start an event");
                        System.out.println("must have been approved by Admin and CSManager");

                        String eventBasedOnRequest = s.nextLine();
                        boolean ok =requestFacade.checkApproval(eventBasedOnRequest);

                        if(ok){
                            eventFacade.createEvent(eventBasedOnRequest);
                            break;
                        }
                        System.out.println("The event request you are attempting to turn into an event has not been approved by both a CSManager and an administrator or has open HR/Financial requests");
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
                        // displays all not only the ones that need approval
                        requestFacade.showEventRequests();
                        System.out.println("Type the name of an event request you would like to approve");
                        String name = s.nextLine();
                        boolean exists=requestFacade.eventRequestExists(name);

                        if (exists){
                            requestFacade.approveEventRequests(name, employee);
                        }
                        else{
                            System.out.println("EventRequest does not exist");
                        }
                        break;
                    case "create financial request":
                        requestFacade.createFinancialRequest();
                        break;
                    case "create HR request":
                        requestFacade.createHRRequest();
                        break;
                    case "review HR requests":
                        requestFacade.viewEventRequestsAwaitingApproval("HR");
                        requestFacade.readHRRequest();
                        break;
                    case "review financial requests":
                        requestFacade.viewEventRequestsAwaitingApproval("financial");
                        // display request
                        requestFacade.readFRequest();
                        break;
                    case "add discount":
                        requestFacade.showEventRequests();
                        System.out.println("For which event request would you like to add a discount?");
                        String nameOfRequest = s.nextLine();
                        requestFacade.addDiscount(nameOfRequest);
                        break;
                        // start up doesnt work yet
                    case "comment on task":
                        //show events for this employee
                        System.out.println(" Select event: ");
                        // gets stuck need another method, show events is not based on ID
                        //eventFacade.viewEvent(employee,employeeData);
                        String selection = s.nextLine();
                        Event ev=eventFacade.getEvent(selection);
                        taskFacade.viewOwnTasks(ev,employee.getEmployeeID());
                        taskFacade.addCommentToTask(employee.getEmployeeID(),ev);
                        break;
                    case "view employees":
                        System.out.println("Not yet implemented");
                        break;
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
