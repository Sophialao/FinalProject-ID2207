package com.company.RequestSub;

import com.company.Request;
import com.company.WorkerSub.Department;


public class FinancialRequest extends Request {
    private String description;
    private String id;
    private String requestingDepartment;
    private String ref;
    private String amount;
    private String concerning;

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

    public void setReuestingDepartment(String requestingDepartment){
        this.requestingDepartment=requestingDepartment;
    }
    public String getReuestingDepartment(){
        return requestingDepartment;
    }

    public void setRef(String ref){
        this.ref=ref;
    }
    public String getRef(){
        return ref;
    }

    public void setConcerningRequest(String con){
        this.concerning=con;
    }
    public String getConcerningRequest(){
        return concerning;
    }

    public void setAmount(String amount){
        this.amount=amount;
    }
    public String getAmount(){
        return amount;
    }


}
