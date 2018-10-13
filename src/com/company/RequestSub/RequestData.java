package com.company.RequestSub;

import java.util.ArrayList;
import java.util.HashMap;

//Strore event requests in a hashmap with name as key
public class RequestData {
    //adds storage for requests submitted for review
    //private HashMap<String,EventRequest> awaitingReviewBank = new HashMap();
    private ArrayList <String> submittedForFinancialReview = new ArrayList();
    private ArrayList <String> submittedForHRReview = new ArrayList();

   private ArrayList <EventRequest> submittedForReview = new ArrayList();

    public void addForReview(EventRequest e){
        // if we want it removed
        //eventRequestsByName.remove(e.getName());
        submittedForReview.add(e);
    }
    public ArrayList getEventRequestsAwaitingReview(){
        return submittedForReview;
    }

    private HashMap<String,HRRequest> HRRequestsByName = new HashMap();
    private HashMap<String,FinancialRequest> financialRequestsByName = new HashMap();
    private HashMap<String,EventRequest> eventRequestsByName = new HashMap();

    public HashMap getEventRequests(){
        return eventRequestsByName;
    }

    //put request in hashmap with name as key
    public void addNewEventRequest(EventRequest e){
        eventRequestsByName.put(e.getName(),e);
    }
    public EventRequest getEventRequest(String name){
        return eventRequestsByName.get(name);
    }

    //financial
    public void addNewFinancialRequest(String concerning, FinancialRequest f){ financialRequestsByName.put(concerning,f);
        submittedForFinancialReview.add(concerning);
    }
    public ArrayList getFinancialRequestsNames(){
        return submittedForFinancialReview;
    }
    public FinancialRequest getFinancialRequest(String name){
        return financialRequestsByName.get(name);
    }

    //HR
    public void addNewHRRequest(HRRequest hr, String name){
        HRRequestsByName.put(name,hr);
        submittedForHRReview.add(name);
    }
    public HRRequest getHRRequest(String name){
        return HRRequestsByName.get(name);
    }

    public ArrayList getHRRequestsNames(){
        return submittedForHRReview;
    }


    //update request
    public void updateRequest(EventRequest e,String key){
        eventRequestsByName.remove(key);
        eventRequestsByName.put(e.getName(),e);
    }
    public void submitForReview(String s){
        submittedForFinancialReview.add(s);
    }
    public void fetchForReview(String eventName){
        eventRequestsByName.get(eventName);
    }

    public void removeFinancialRequest(String name){
        submittedForFinancialReview.remove(name);
    }
    public void removeHRRequest(String name){
        submittedForFinancialReview.remove(name);
    }

    public void startUp(){

        // event request 1
        EventRequest e = new EventRequest();
        e.setBudget("12");
        e.setDescription("Test request for an event");
        e.setName("bob");
        e.setEndDate("12-08-18");
        e.setStartDate("11-08-18");

        // approved by manager
        e.setApprovedByCSManger();

        eventRequestsByName.put(e.getName(),e);

        // event request 2
        EventRequest e2 = new EventRequest();
        e2.setBudget("12");
        e2.setDescription("Test request for an event");
        e2.setName("party");
        e2.setEndDate("12-08-18");
        e2.setStartDate("11-08-18");

        // approved by all
        e2.setApprovedByCSManger();
        e2.setApprovedByAdmin();

        eventRequestsByName.put(e2.getName(),e2);

        // Financial request
        FinancialRequest f = new FinancialRequest();
        f.setConcerningRequest("bob");
        f.setDescription("Financial request concerning the bob event request");
        f.setRef("some person");
        f.setReuestingDepartment("A department");
        f.setAmount("123");

        // dont really need both
        financialRequestsByName.put(f.getConcerningRequest(),f);
        submittedForFinancialReview.add(f.getConcerningRequest());

    }
}
