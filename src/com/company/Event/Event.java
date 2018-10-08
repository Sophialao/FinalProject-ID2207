package com.company.Event;

import java.util.HashMap;

public class Event {

    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private String budget;
    private String feedback;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setStartDate(String date){
        this.startDate=date;
    }
    public String getStartDate(){
        return startDate;
    }

    public void setEndDate(String date){
        this.endDate=date;
    }
    public String getEndDate(){
        return endDate;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }

    public void setBudget(String budget){
        this.budget=budget;
    }
    public String getBudget(){
        return budget;
    }
}
