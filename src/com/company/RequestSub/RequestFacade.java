package com.company.RequestSub;

import com.company.WorkerSub.Employee;

public class RequestFacade {
    RequestHandler requestHandler = new RequestHandler();

    public void addDiscount(String name){
        requestHandler.addDiscount(name);
    }
    public boolean checkApproval(String name){
        boolean ok=requestHandler.checkApproval(name);
        return ok;
    }
    public void createEventRequest(){
        requestHandler.createEventRequest();

    }
    public void readHRRequest(){
        requestHandler.readHRRequest();
    }
    public void readFRequest(){
        requestHandler.readFRequest();
    }
    public void viewEventRequest(){
        requestHandler.viewEventRequests();
    }

    public void updateEventRequest(){
        requestHandler.updateRequest();
    }
    public void approveEventRequests(String name, Employee emp){
        requestHandler.approveEventRequest(name, emp);
    }
    public void showEventRequests(){
        requestHandler.showEventRequests();
    }

    public void createFinancialRequest(){
        requestHandler.createFinancialRequest();
    }
    public void createHRRequest(){
        requestHandler.createHRRequest();
    }

    public void viewEventRequestsAwaitingApproval(String type)
    {
        requestHandler.viewHRFRequestsAwaitingApproval(type);
    }
    public boolean eventRequestExists(String name){
        return requestHandler.eventRequestExists(name);
    }
    public void startUp(){
        requestHandler.startUpDB();
    }

}
