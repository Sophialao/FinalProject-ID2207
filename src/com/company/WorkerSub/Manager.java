/*
 * TBD
 */
package com.company.WorkerSub;

public class Manager extends Employee
{
    public Manager(int employeeID, String name, String address, int hourlyPay, String phoneNumber, String employeeType,boolean isAdmin,String[] accessRights)
    {
        super(employeeID, name, address, hourlyPay, phoneNumber,employeeType,isAdmin,accessRights);
    }

    @Override
    public boolean isManager()
    {
        return true;
    }

}
