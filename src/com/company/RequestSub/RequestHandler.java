package com.company.RequestSub;

import java.util.HashMap;
import java.util.Scanner;

public class RequestHandler {
    Scanner s = new Scanner(System.in);
    RequestData requestData = new RequestData();

    //EVENT REQUESTS
    //loop through hashmap and print names of event requests
    public void showEventRequests(){
        System.out.println("--- VIEW EVENT REQUESTS ---");
        HashMap requests=requestData.getEventRequests();

            for (Object ro : requests.values()){

             //iterate over values
             EventRequest r = (EventRequest) ro;
             System.out.println(r.getName());
            }
    }
    //lists all saved event requests
    public void viewEventRequests(){
        showEventRequests();
        readRequest(chooseEventRequest());
    }
    //allows usr to choose a request to continue with (update/view details)
    public EventRequest chooseEventRequest(){
        Scanner s = new Scanner(System.in);
        //System.out.println("Type the name of an event request to continue");
        System.out.println("Type the name of an event request you would like to view");
        String name=s.nextLine();
        if(!requestData.getEventRequests().containsKey(name)){
            System.out.println("Event request " + name +" does not exist");
            //TODO prompt agan if cant find
        }
        return requestData.getEventRequest(name);
    }

    public void approveEventRequestCSManager()
    {
        showEventRequests();
        Scanner s = new Scanner(System.in);
        //System.out.println("Type the name of an event request to continue");
        System.out.println("Type the name of an event request you would like to approve");
        //TODO only include events that have not been approved yet
        String name=s.nextLine();
        if(!requestData.getEventRequests().containsKey(name)){
            System.out.println("Event request " + name +" does not exist");
            //TODO prompt agan if cant find
        }
        EventRequest e = requestData.getEventRequest(name);
        e.setApprovedByCSManger();
        System.out.println("Event approved!");
    }
    public void approveEventRequestAdmin()
    {
        showEventRequests();
        Scanner s = new Scanner(System.in);
        //System.out.println("Type the name of an event request to continue");
        System.out.println("Type the name of an event request you would like to approve");
        //TODO only include events that have not been approved yet
        String name=s.nextLine();
        if(!requestData.getEventRequests().containsKey(name)){
            System.out.println("Event request " + name +" does not exist");
            //TODO prompt agan if cant find
        }
        EventRequest e = requestData.getEventRequest(name);
        e.setApprovedByAdmin();
        System.out.println("Event approved!");
    }

    //can be done in a more effective way, loop through
    private void readRequest(EventRequest e)
    {
        if(e == null)
        {
            return;
        }
        System.out.println("--- "+e.getName().toUpperCase()+" ---");
        System.out.println("Event name: " + e.getName());
        System.out.println("From: " + e.getStartDate());
        System.out.println("To: "+ e.getEndDate());
        System.out.println("Expected budget: "+ e.getBudget());
        System.out.println("Description: "+ e.getDescription());
        System.out.println("Aproved by CS Manager: " + e.approvedByCSManger());
        System.out.println("Approved by Admin: " + e.approvedByAdmin());
    }
    public void createEventRequest(){
        System.out.println("---CREATE EVENT REQUEST---");
        EventRequest eventRequest = new EventRequest();
        EventRequest e=fillInEventRequest(eventRequest);
        storeEventRequest(e);
        System.out.println("Event request -"+eventRequest.getName()+ "- created! ");
    }
    //can be done in a more effective way
    private EventRequest fillInEventRequest(EventRequest eventRequest){

        System.out.print("Event name: ");
        String name=s.nextLine();
        eventRequest.setName(name);
        System.out.print("From: ");
        String from=s.nextLine();
        eventRequest.setStartDate(from);
        System.out.print("To: ");
        String to=s.nextLine();
        eventRequest.setEndDate(to);
        System.out.print("Expected budget: ");
        String budget=s.nextLine();
        eventRequest.setBudget(budget);
        System.out.print("Details: ");
        String details=s.nextLine();
        eventRequest.setDescription(details);

        //more
        return eventRequest;
    }

    private void storeEventRequest(EventRequest r){
        requestData.addNewEventRequest(r);
        System.out.println("Event request saved to database ");
    }
    public void updateRequest(){

        showEventRequests();
        EventRequest oldRequest = chooseEventRequest();
        readRequest(oldRequest);

        // update
        Scanner s = new Scanner(System.in);
        String oldName= oldRequest.getName();
        System.out.println("---- UPDATE "+oldRequest.getName().toUpperCase()+"----");
        EventRequest newEventRequest= fillInEventRequest(oldRequest);
        requestData.updateRequest(newEventRequest,oldName);

    }

    //HR REQUESTS
    public void createHRRequest(){
        System.out.println("--- CREATE HR REQUEST ---");
        HRRequest hrRequest = new HRRequest();
        HRRequest hrr=fillInHRRequest(hrRequest);
        //attach hr request to event request
        //storeEventRequest(hrr);
        //System.out.println("Event request -"+hrRequest.getName()+ "- created! ");
    }
    //can be done in a more effective way
    private HRRequest fillInHRRequest(HRRequest hrRequest){
/*
        System.out.print("Concerning event: ");
        String name=s.nextLine();
        //to connect request and event request
        //add department
        hrRequest.setDepartment(name);

*/
        //more
        return hrRequest;
    }
    //FINANCIAL REQUESTS
    public void createFinancialRequest(){
        System.out.println("--- CREATE FINANCIAL REQUEST ---");
        FinancialRequest financialRequest = new FinancialRequest();
        //HRRequest hrr=fillInHRRequest(hrRequest);
        //attach hr request to event request
        //storeEventRequest(hrr);
        //System.out.println("Event request -"+hrRequest.getName()+ "- created! ");
    }
}
