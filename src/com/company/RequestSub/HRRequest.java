package com.company.RequestSub;

import com.company.Request;


public class HRRequest extends Request {
    private String description;
    private String id;
    private String time;
    private String requestingDepartment;
    private String concerning;
    private String experience;
    private String title;

    public void setExperience(String experience){
        this.experience =experience;
    }
    public String getexperience(){
        return experience;
    }

    public void setTitle(String title){
        this.title =title;
    }
    public String getTitle(){ return title;
    }

    public void setID(String id){
        this.id =id;
    }
    public String getID(){
        return id;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }

    public void setTime(String time){
        this.time =time;
    }
    public String getTime(){
        return time;
    }

    public void setReuestingDepartment(String requestingDepartment){
        this.requestingDepartment=requestingDepartment;
    }
    public String getReuestingDepartment(){
        return requestingDepartment;
    }

    public void setConcerningRequest(String con){
        this.concerning=con;
    }
    public String getConcerningRequest(){
        return concerning;
    }

}