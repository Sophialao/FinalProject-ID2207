package com.company;

import com.company.WorkerSub.EmployeeData;

public class LoginFacade {

    LoginHandler loginHandler;

    public LoginFacade(){
        loginHandler = new LoginHandler();

    }
    public int logIn(EmployeeData employeeData){
        return loginHandler.logIn(employeeData);
    }

}
