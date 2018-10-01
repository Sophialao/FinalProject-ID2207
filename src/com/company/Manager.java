/*
 * TBD
 */
package com.company;

public class Manager extends Employee
{
    public Manager(int employeeID, String name, String address, int hourlyPay, String phoneNumber, boolean isAdmin,
                   boolean isCS)
    {
        super(employeeID, name, address, hourlyPay, phoneNumber,isAdmin,isCS);
    }

    @Override
    public boolean isManager()
    {
        return true;
    }

}
