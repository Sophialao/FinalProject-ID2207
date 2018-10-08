package com.company.RequestSub;
import com.company.Request;

import java.util.HashMap;

public class EventRequest extends Request {
    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private String budget;
    private String id;
    private HashMap<String,String> feedback;

    public void setID(String id){
        this.id =id;
    }
    public String getID(){
        return id;
    }

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


    public void setComment(String user,String comment){
        feedback.put(user,comment);
    }
    public HashMap getFeedback(){
        return feedback;
    }
}
