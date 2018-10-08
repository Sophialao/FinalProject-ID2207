package com.company.Event;

import com.company.RequestSub.EventRequest;

import java.util.HashMap;
import java.util.Scanner;

//same as requests if needed
public class EventHandler {
    EventData eventData = new EventData();
    Scanner s = new Scanner(System.in);


    //loop through hashmap and print names of event requests
    public void showEvents(){
        System.out.println("--- VIEW EVENTS ---");

        HashMap requests=eventData.getEvents();

        if(requests.isEmpty())
        {
            System.out.println("There are currently no events");
        }
        for (Object ev : requests.values()){
            //iterate over values
            Event e = (Event) ev;
            System.out.println(e.getName());
        }
    }
    //lists all saved event requests
    public void viewEvent(){
        showEvents();
        readEvent(chooseEvent());
    }
    //allows usr to choose a request to continue with (update/view details)
    public Event chooseEvent(){
        System.out.println("Type the name of an event to continue");
        String name=s.nextLine();

        return eventData.getEvent(name);
    }

    //can be done in a more effective way, loop through
    private void readEvent(Event e){
        System.out.println("--- "+e.getName().toUpperCase()+" ---");
        System.out.println("Event name: " + e.getName());
        System.out.println("From: " + e.getStartDate());
        System.out.println("To: "+ e.getEndDate());
        System.out.println("Budget: "+ e.getBudget());
        System.out.println("Description: "+ e.getDescription());
    }
    public void createEvent(){
        System.out.println("---CREATE EVENT REQUEST---");
        Event event = new Event();
        Event e=fillInEvent(event);
        storeEvent(e);
        System.out.println("Event -"+event.getName()+ "- created! ");
    }
    //can be done in a more effective way
    private Event fillInEvent(Event event){

        System.out.print("Event name: ");
        String name=s.nextLine();
        event.setName(name);
        System.out.print("From: ");
        String from=s.nextLine();
        event.setStartDate(from);
        System.out.print("To: ");
        String to=s.nextLine();
        event.setEndDate(to);
        System.out.print("Budget: ");
        String budget=s.nextLine();
        event.setBudget(budget);
        System.out.print("Details: ");
        String details=s.nextLine();
        event.setDescription(details);

        //more
        return event;
    }

    private void storeEvent(Event e){
        eventData.addNewEvent(e);
        System.out.println("Event saved to database ");
    }
    public void updateEvent(){

        showEvents();
        Event oldEvent = chooseEvent();
        readEvent(oldEvent);

        // update
        Scanner s = new Scanner(System.in);
        String oldName= oldEvent.getName();
        System.out.println("---- UPDATE "+oldEvent.getName().toUpperCase()+"----");
        Event newEvent= fillInEvent(oldEvent);
        eventData.updateEvent(newEvent,oldName);

    }
}
