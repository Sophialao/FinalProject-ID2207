package com.company.Event;

import com.company.RequestSub.EventRequest;

import java.util.HashMap;

//Strore events in a hashmap with name as key
public class EventData {

    private HashMap<String,Event> eventByName = new HashMap();

    public HashMap getEvents(){

        return eventByName;
    }

    //put request in hashmap with name as key
    public void addNewEvent(Event e){

        eventByName.put(e.getName(),e);
    }
    public Event getEvent(String name){
        return eventByName.get(name);
    }
    //update event
    public void updateEvent(Event e,String key){
        eventByName.remove(key);
        eventByName.put(e.getName(),e);
    }
    public void startUp(){
        Event e = new Event();
        e.setBudget("12");
        e.setDescription("aldjla");
        e.setEndDate("2");
        e.setName("TestEvent");
        e.setStartDate("1");

        addNewEvent(e);
    }
}
