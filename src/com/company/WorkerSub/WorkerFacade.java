package com.company.WorkerSub;

public class WorkerFacade {

    EmployeeData employeeData;

    public Employee getEmployee(int employeeID){

        return employeeData.getEmployee(employeeID);
    }

}
