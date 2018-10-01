package com.company;
/*
 * This class controls tasks having to do with employees
 * such as storage, logging in, and ....update to be more precise
 */

import java.util.ArrayList;
import java.util.Hashtable;

public class EmployeeController
{
    //Hashtable from usernames to passwords //not to be implemented in an actual application!!!
    private Hashtable<String,String> employeeCredentials = new Hashtable<>();
    private ArrayList<Employee> employeeData = new ArrayList<>();
    //Used for faster look up of the employee after a valid userName is entered
    private Hashtable<String,Integer> userNameToEmployeeID = new Hashtable<>();

    /**
     * This method is called upon starting the system to populate the
     * arrayLIst being used as a database for storing credentials and
     * populating the hashtable used to store employee credentials.
     */
    public void startUp()
    {
        employeeData.add(new Employee(1, "CSEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,true));
        employeeData.add(new Employee(2, "CSEmployee2", "8906 Broadway ln, Englewood, Al, 70374"
                , 16, "8749580839",false,true));
        employeeData.add(new Manager(3, "CSManager", "9827 Broadway ln, Englewood, Al, 70374"
                , 30, "8495837485", false,true));
        employeeData.add(new Employee(4, "FEmployee1", "803 E Green St,Urbana Il, 61801"
                , 16, "9807867586",false,false));
        employeeData.add(new Manager(5, "FManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", false,false));

        //The addresses and phone numbers are the same b/c I didn't want to make more up

        employeeData.add(new Employee(6, "PEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Employee(7, "PEmployee2", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Employee(8, "PEmployee3", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Employee(9, "PEmployee4", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Employee(10, "PEmployee5", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Manager(11, "PManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", false,false));

        employeeData.add(new Employee(12, "SEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Employee(13, "SEmployee2", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Employee(14, "SEmployee3", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Employee(15, "SEmployee4", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",false,false));
        employeeData.add(new Manager(16, "SManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", false,false));

        employeeData.add(new Employee(17, "AEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",true,false));
        employeeData.add(new Employee(18, "AEmployee2", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",true,false));
        employeeData.add(new Employee(19, "AEmployee3", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",true,false));
        employeeData.add(new Employee(20, "AEmployee4", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",true,false));
        employeeData.add(new Manager(21, "AManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", true,false));

        employeeData.add(new Employee(22, "Secretary", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366",true,false));
        employeeData.add(new Manager(23, "VPresident", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", true,false));



        employeeCredentials.put("CSEmployee1","CSEmployee1Pass");
        employeeCredentials.put("CSEmployee2","CSEmployee2Pass");
        employeeCredentials.put("CSManager","CSManagerPass");
        employeeCredentials.put("FEmployee1","FEmployee1Pass");
        employeeCredentials.put("FManager","FManagerPass");
        employeeCredentials.put("PEmployee1","PEmployee1Pass");
        employeeCredentials.put("PEmployee2","PEmployee2Pass");
        employeeCredentials.put("PEmployee3","PEmployee3Pass");
        employeeCredentials.put("PEmployee4","PEmployee4Pass");
        employeeCredentials.put("PEmployee5","PEmployee5Pass");
        employeeCredentials.put("PManager","PManagerPass");
        employeeCredentials.put("SEmployee1","SEmployee1Pass");
        employeeCredentials.put("SEmployee2","SEmployee2Pass");
        employeeCredentials.put("SEmployee3","SEmployee3Pass");
        employeeCredentials.put("SEmployee4","SEmployee4Pass");
        employeeCredentials.put("SManager","SManagerPass");
        employeeCredentials.put("AEmployee1","AEmployee1Pass");
        employeeCredentials.put("AEmployee2","AEmployee2Pass");
        employeeCredentials.put("AEmployee3","AEmployee3Pass");
        employeeCredentials.put("AEmployee4","AEmployee4Pass");
        employeeCredentials.put("AManager","AManagerPass");
        employeeCredentials.put("Secretary","SecretaryPass");
        employeeCredentials.put("VPresident","VPresidentPass");


        userNameToEmployeeID.put("CSEmployee1",1);
        userNameToEmployeeID.put("CSEmployee2",2);
        userNameToEmployeeID.put("CSManager",3);
        userNameToEmployeeID.put("FEmployee1",4);
        userNameToEmployeeID.put("FManager",5);
        userNameToEmployeeID.put("PEmployee1",6);
        userNameToEmployeeID.put("PEmployee2",7);
        userNameToEmployeeID.put("PEmployee3",8);
        userNameToEmployeeID.put("PEmployee4",9);
        userNameToEmployeeID.put("PEmployee5",10);
        userNameToEmployeeID.put("PManager",11);
        userNameToEmployeeID.put("SEmployee1",12);
        userNameToEmployeeID.put("SEmployee2",13);
        userNameToEmployeeID.put("SEmployee3",14);
        userNameToEmployeeID.put("SEmployee4",15);
        userNameToEmployeeID.put("SManager",16);
        userNameToEmployeeID.put("AEmployee1",17);
        userNameToEmployeeID.put("AEmployee2",18);
        userNameToEmployeeID.put("AEmployee3",19);
        userNameToEmployeeID.put("AEmployee4",20);
        userNameToEmployeeID.put("AManager",21);
        userNameToEmployeeID.put("Secretary",20);
        userNameToEmployeeID.put("VPresident",22);
    }

    /**
     * Checks the userName and password given, and if valid returns the corresponding employee ID.
     * Otherwise 0 is returned
     * @param userName
     * @param password
     * @return
     */
    public int checkLogIn(String userName,String password)
    {
        //Checks what the passcode in the database is for a userName with the
        //white space at the end trimmed off
        String passInDataBase = employeeCredentials.get(userName.trim());
        if(passInDataBase == null || !passInDataBase.equals(password.trim()))
        {
            System.out.println("Log in unsuccessful, please try again");
            return 0;
        }
        System.out.println("Log in successful");
        //fix this
        return getEmployeeID(userName.trim());
    }

    public int getEmployeeID(String userName)
    {
        return userNameToEmployeeID.get(userName);
    }

    public Employee getEmployee(int employeeID)
    {
        return employeeData.get(employeeID-1);
    }

    //Display the actions that the employee can do
    public void showActions(Employee employee)
    {
        System.out.println("What would you like to do? Please type the action in parentheses");
        System.out.print("View events(view events)");

        if(employee.isCS() || employee.isManager() || employee.isAdmin())
        {
            System.out.print(", view clients(view clients)");
        }
        if(employee.isCS() || employee.isAdmin())
        {
            System.out.print(", edit clients(edit clients), new event request(new event request)");
        }
        if(employee.isManager() || employee.isAdmin())
        {
            System.out.print(", view employees(view employees)");
        }
        if(employee.isAdmin())
        {
            System.out.print(", edit employees(edit employees)");
        }
        System.out.println(", exit(exit)");
    }
}
