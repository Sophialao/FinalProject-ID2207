package com.company.RequestSub;

import com.company.Request;


public class HRRequest extends Request {
    private String description;
    private String id;

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

}