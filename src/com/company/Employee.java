/*
 * Description to be added
 */
package com.company;

public class Employee
{
    private int employeeID;
    private String name;
    private String address;
    private int hourlyPay;
    private String phoneNumber;
    private boolean isAdmin;
    //if the employee is a customer service employee or not
    private boolean isCS;

    public Employee(int employeeID, String name, String address, int hourlyPay, String phoneNumber, boolean isAdmin,
                    boolean isCS)
    {
        //Do we put the employeeID in the constructor as a or do we create it
        this.employeeID = employeeID;
        this.name = name;
        this.address = address;
        this.hourlyPay = hourlyPay;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        this.isCS = isCS;
    }

    public String getName() { return name; }
    public String getAdress() { return address; }
    public int getHourlyPay() { return hourlyPay; }
    public String getPhoneNumber() { return phoneNumber; }

    public boolean isManager()
    {
        return false;
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }
    public boolean isCS()
    {
        return isCS;
    }
}
