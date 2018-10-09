package com.company.RequestSub;

public class RequestFacade {
    RequestHandler requestHandler = new RequestHandler();

    public void createEventRequest(){
        requestHandler.createEventRequest();

    }
    public void viewEventRequest(){
        requestHandler.viewEventRequests();
    }

    public void updateEventRequest(){
        requestHandler.updateRequest();
    }
    public void approveEventRequestCSManager(){
        requestHandler.approveEventRequestCSManager();
    }
    public void approveEventRequestAdmin(){
        requestHandler.approveEventRequestAdmin();
    }

    public void createFinancialRequest(){
        requestHandler.createFinancialRequest();
    }
    public void createHRRequest(){
        requestHandler.createHRRequest();
    }

}
