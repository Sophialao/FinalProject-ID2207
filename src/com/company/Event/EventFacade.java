package com.company.Event;

public class EventFacade {
    EventHandler eventHandler = new EventHandler();

    public void showEvents(){
        eventHandler.showEvents();
    }

    public void createEvent(){
        eventHandler.createEvent();

    }
    public void viewEvent(){
        eventHandler.viewEvent();
    }

    public void updateEvent(){
        eventHandler.updateEvent();
    }
}
