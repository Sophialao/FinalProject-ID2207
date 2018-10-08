package com.company.WorkerSub;
/*
 * This class controls tasks having to do with employees
 * such as storage, logging in, and ....update to be more precise
 */

import java.util.ArrayList;
import java.util.Hashtable;

public class EmployeeData
{
    //Hashtable from usernames to passwords //not to be implemented in an actual application!!!
    private Hashtable<String,String> employeeCredentials = new Hashtable<>();
    private Hashtable<String, String[]> accessRights = new Hashtable<>();
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

        //AccessRights (not all need to be functional)
        String[] CSManagerAccess = {"view event", "view event requests", "update request", "submit for financial review"};
        String[] CSEmployee1Access = {"view event", "create event request", "submit for financial review"};
        String[] FManagerAccess = {"view event", "add discount", "update event request","view event requests"};
        String[] FEmployee1Access = {"view event", "update request","view event requests"};
        String[] PEmployee1Access = {"view event"};
        String[] PManagerAccess = {"view event","create task","view employee","view client","update event","update event request","view event requests","create financial request","create HR request"};
        String[] SManagerAccess = {"view event","view event requests","update request","create task","create financial request","create HR request"};
        String[] SEmployee1Access = {"view event"};
        String[] VPresidentAccesss = {"view event","view employees","edit employees","view clients","edit clients","edit event","view event requests","update event request"};
        String[] SudoAccess = {"view event","create financial request","create HR request", "create event request","add discount", "create financial request","create task","view employees","edit employees","view clients","edit clients","edit event","view event requests","update event request"};

        accessRights.put("CSManager",CSManagerAccess);
        accessRights.put("CSEmployee1",CSEmployee1Access);
        accessRights.put("FManager",FManagerAccess);
        accessRights.put("FEmployee1",FEmployee1Access);
        accessRights.put("PEmployee1",PEmployee1Access);
        accessRights.put("PManager",PManagerAccess);
        accessRights.put("SManager",SManagerAccess);
        accessRights.put("SEmployee1",SEmployee1Access);
        accessRights.put("VPresident",VPresidentAccesss);
        accessRights.put("sudo",SudoAccess);

        //Customer Service
        employeeData.add(new Manager(1, "CSManager", "9827 Broadway ln, Englewood, Al, 70374"
            , 30, "8495837485", "CustomerService",false,CSManagerAccess));
        employeeData.add(new Employee(2, "CSEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","CustomerService", false, CSEmployee1Access));
        //Financial
        employeeData.add(new Manager(3, "FManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "Financial",false,FManagerAccess));
        employeeData.add(new Employee(4, "FEmployee1", "803 E Green St,Urbana Il, 61801"
                , 16, "9807867586","Financial",false,FEmployee1Access));

        //The addresses and phone numbers are the same b/c I didn't want to make more up
        //Production
        employeeData.add(new Manager(5, "PManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "Production",false,PManagerAccess));
        employeeData.add(new Manager(6, "PEmployee1", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "Production",false,PEmployee1Access));
        //Service
        employeeData.add(new Manager(7, "SManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "Service",false,SManagerAccess));
        employeeData.add(new Employee(8, "SEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","Service",false,SEmployee1Access));

        //Administration
        employeeData.add(new Manager(9, "VPresident", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "Administration",false,VPresidentAccesss));

        //usernames and passwords
        employeeCredentials.put("CSManager","Pass");
        employeeCredentials.put("CSEmployee1","Pass");
        employeeCredentials.put("FManager","Pass");
        employeeCredentials.put("FEmployee1","Pass");
        employeeCredentials.put("PManager","Pass");
        employeeCredentials.put("PEmployee1","Pass");
        employeeCredentials.put("SManager","Pass");
        employeeCredentials.put("SEmployee1","Pass");
        employeeCredentials.put("VPresident","Pass");

        //username linked to ID
        userNameToEmployeeID.put("CSManager",1);
        userNameToEmployeeID.put("CSEmployee1",2);
        userNameToEmployeeID.put("FManager",3);
        userNameToEmployeeID.put("FEmployee1",4);
        userNameToEmployeeID.put("PEmployee1",5);
        userNameToEmployeeID.put("PManager",6);
        userNameToEmployeeID.put("SManager",7);
        userNameToEmployeeID.put("SEmployee1",8);
        userNameToEmployeeID.put("VPresident",9);



        //for testing
        employeeData.add(new Employee(10, "emp", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","Service",false,SudoAccess));
        employeeCredentials.put("emp","emp");
        userNameToEmployeeID.put("emp",10);
    }

    public String[] getAccessRights(Employee employee){
       return accessRights.get(employee.getEmployeeType());
    }
    public String getEmployeeCredentials(String userName){
        return employeeCredentials.get(userName.trim());
    }
    public int getEmployeeID(String userName)
    {
        return userNameToEmployeeID.get(userName.trim());
    }

    public Employee getEmployee(int employeeID)
    {
        return employeeData.get(employeeID-1);
    }



}
