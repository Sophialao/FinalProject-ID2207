package com.company.Event;

import com.company.WorkerSub.Employee;
import com.company.WorkerSub.EmployeeData;

public class EventFacade {
    EventHandler eventHandler = new EventHandler();

    public void showEvents(){
        eventHandler.showEvents();
    }

    public void createEvent(String name){
        eventHandler.createEvent(name);

    }
    public void viewEvent(Employee employee, EmployeeData employeeData){
        eventHandler.viewEvent(employee,employeeData);
    }

    public void updateEvent(){
        eventHandler.updateEvent();
    }

    public void startUp(){
        eventHandler.startUp();
    }
    public Event getEvent(String name){
        return eventHandler.getEvent(name);
    }
}
