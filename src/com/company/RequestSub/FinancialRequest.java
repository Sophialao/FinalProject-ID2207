package com.company.RequestSub;

import com.company.Request;
import com.company.WorkerSub.Department;


public class FinancialRequest extends Request {
    private String description;
    private String id;
    private Department requestingDepartment;

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

    public void setReuestingDepartment(Department requestingDepartment){
        this.requestingDepartment=requestingDepartment;
    }
    public Department getReuestingDepartment(){
        return requestingDepartment;
    }

}
