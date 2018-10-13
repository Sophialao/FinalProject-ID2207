package com.company.RequestSub;

import com.company.WorkerSub.Employee;

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
        System.out.println("Type the name of an event request you would like to view, or back to go back");
        String name=s.nextLine();
        if(!requestData.getEventRequests().containsKey(name)){
            System.out.println("Event request " + name +" does not exist");
            //TODO prompt agan if cant find
        }
        return requestData.getEventRequest(name);
    }

    /*public void approveEventRequestCSManager()
    {
        showEventRequests();
        Scanner s = new Scanner(System.in);
        //System.out.println("Type the name of an event request to continue");
        System.out.println("Type the name of an event request you would like to approve");
        //TODO only include events that have not been approved yet

        // get event names from list not approved yet by CS (boolean false)
        String name=s.nextLine();
        if(!requestData.getEventRequests().containsKey(name)){
            System.out.println("Event request " + name +" does not exist");
            //TODO prompt agan if cant find
        }
        EventRequest e = requestData.getEventRequest(name);
        e.setApprovedByCSManger();
        System.out.println("Event approved!");
    }*/

    //might need later
   public void viewHRFRequestsAwaitingApproval(String type)
    {

        if(type.equals("financial")) {
            System.out.println("EventRequests with pending financial requests: ");
            // show financial requests
            for (int i = 0; i < requestData.getFinancialRequestsNames().size(); i++) {
                // print all requests with a financial request
                System.out.println(requestData.getFinancialRequestsNames().get(i));
            }
        }
        else{
            System.out.println("EventRequests with pending HR requests: ");
            // show HR requests
            for (int i = 0; i < requestData.getHRRequestsNames().size(); i++) {
                // print all requests with a financial request
                System.out.println(requestData.getHRRequestsNames().get(i));
            }
        }


    }
    public boolean eventRequestExists(String name){
        if(!requestData.getEventRequests().containsKey(name)){
            System.out.println("Event request " + name +" does not exist");
            return false;
        }
        return true;
    }
    public void approveEventRequest(String name, Employee emp){
        EventRequest e = requestData.getEventRequest(name);

        if(emp.getEmployeeType().equals("CSManager")){
            e.setApprovedByCSManger();
        }
        else{
            e.setApprovedByAdmin();
        }

        requestData.addForReview(e);
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

    //HR REQUESTS. fill in and add to database (connected to requests by name
    public void createHRRequest(){
        System.out.println("--- CREATE HR REQUEST ---");
        System.out.print("Concerning event: ");
        String name=s.nextLine();
        if(requestData.getEventRequests().containsKey(name)) {
            HRRequest hrRequest = new HRRequest();
            HRRequest hrr = fillInHRRequest(hrRequest, name);
            // store
            requestData.addNewHRRequest(hrr, hrRequest.getConcerningRequest());
            System.out.println("HR request concerning -" + hrRequest.getConcerningRequest() + "- created! ");
        }
        else {
            System.out.println("To create a HR request there needs to be an active event request");
        }
    }
    //can be done in a more effective way
    private HRRequest fillInHRRequest(HRRequest hrRequest, String name){

        hrRequest.setConcerningRequest(name);

        System.out.print("Full time/ part time:  ");
        String time=s.nextLine();
        hrRequest.setTime(time);

        System.out.print("Requesting department: ");
        String dept=s.nextLine();
        hrRequest.setReuestingDepartment(dept);

        System.out.print("Years of experience: ");
        String experience=s.nextLine();
        hrRequest.setExperience(experience);

        System.out.print("Job title ");
        String title=s.nextLine();
        hrRequest.setTitle(title);

        System.out.print("Description: ");
        String description=s.nextLine();
        hrRequest.setDescription(description);

        return hrRequest;
    }
    //FINANCIAL REQUESTS. fill in and add to database (connected to requests by name
    public void createFinancialRequest(){
        System.out.println("--- CREATE FINANCIAL REQUEST ---");
        System.out.print("Concerning event: ");
        String name=s.nextLine();

        if(requestData.getEventRequests().containsKey(name)) {
            FinancialRequest financialRequest = new FinancialRequest();
            financialRequest = fillInFinancialRequest(financialRequest, name);
            // store
            requestData.addNewFinancialRequest(financialRequest.getConcerningRequest(), financialRequest);
            //System.out.println("Event request -"+hrRequest.getName()+ "- created! ");
        }
        else {
            System.out.println("To create a financial request there needs to be an active event request");
        }
    }
    private FinancialRequest fillInFinancialRequest(FinancialRequest frRequest, String name){

        frRequest.setConcerningRequest(name);

        System.out.print("Requesting department: ");
        String dept=s.nextLine();
        frRequest.setReuestingDepartment(dept);

        System.out.print("Input project reference: ");
        String ref=s.nextLine();
        frRequest.setRef(ref);

        System.out.print("Required amount: ");
        String amount=s.nextLine();
        frRequest.setAmount(amount);

        System.out.print("State a reason: ");
        String reason=s.nextLine();
        frRequest.setDescription(reason);

        return frRequest;
    }
    public void addDiscount(String name){
       EventRequest r=requestData.getEventRequest(name);
        System.out.print("Specify discount in %: ");
        String discount=s.nextLine();
        r.setDiscount(discount);
        System.out.println("A discount of "+discount+" was added to " + name);
    }
    public void readFRequest() {

            System.out.println("Choose a request to review or type back to go back");
            String choice = s.nextLine();
            if (choice.equals("back")) {
                return;
            }
            FinancialRequest fr = requestData.getFinancialRequest(choice);
            System.out.println("Concerning event: " + fr.getConcerningRequest());
            System.out.println("Requesting department: " + fr.getReuestingDepartment());
            System.out.println("Input project reference: " + fr.getRef());
            System.out.println("Required amount: " + fr.getAmount());
            System.out.println("State a reason: " + fr.getDescription());

            handleFinancialRequest(choice);
        }

        public void readHRRequest(){

            System.out.println("Choose a request to review or type back to go back");
            String choice = s.nextLine();
            if(choice.equals("back")) {
                return;
            }

            HRRequest hrRequest = requestData.getHRRequest(choice);
            System.out.println("Concerning event: " + hrRequest.getConcerningRequest());
            System.out.println("Full time/ part time:  " + hrRequest.getTime());
            System.out.println("Requesting department: " + hrRequest.getReuestingDepartment());
            System.out.println("Years of experience: " + hrRequest.getexperience());
            System.out.println("Job title " + hrRequest.getTitle());
            System.out.println("Description: " + hrRequest.getDescription());

            handleHRRequest(choice);

        }
        public void handleFinancialRequest(String name){
            System.out.println();
            System.out.println("Mark " + name+" as handled? yes/no");
            String choice = s.nextLine();
            if(choice.equals("yes")){
                requestData.removeFinancialRequest(name);
            }
            System.out.println("request for " + name + " was marked as handled");
        }
    public void handleHRRequest(String name){
        System.out.println();
        System.out.println("Mark " + name+" as handled? yes/no");
        String choice = s.nextLine();
        if(choice.equals("yes")){
            requestData.removeHRRequest(name);
        }
        System.out.println("request for " + name + " was marked as handled");
    }

        public boolean checkApproval (String name){
            EventRequest e = requestData.getEventRequest(name);
            if (e.approvedByAdmin() && e.approvedByCSManger() == true) {
                return true;
            }
            return false;
        }
        public void startUpDB () {
            requestData.startUp();
        }

    // send to admin department

}
