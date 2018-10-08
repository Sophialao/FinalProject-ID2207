package com.company.RequestSub;

import java.util.HashMap;

//Strore event requests in a hashmap with name as key
public class RequestData {

    //private ArrayList eventRequests= new ArrayList();
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

    //update request
    public void updateRequest(EventRequest e,String key){
        eventRequestsByName.remove(key);
        eventRequestsByName.put(e.getName(),e);
    }
}
