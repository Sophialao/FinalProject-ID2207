package com.company.TaskSub;

import com.company.Event.Event;
import com.company.WorkerSub.Employee;

public class Task
{
    private String name;
    private Employee employee;
    private Event event;
    private String description;
    private Comment c;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }

    public void setEmployee(Employee employee){
        this.employee=employee;
    }
    public Employee getEmployee(){
        return employee;
    }

    public void setEvent(Event event){
        this.event=event;
    }
    public Event getEvent(){
        return event;
    }

    public void setComment(Comment c){
        this.c=c;
    }
    public Comment getComment(){
        return c;
    }

}
