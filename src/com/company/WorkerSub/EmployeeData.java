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
        String[] CSManagerAccess = {"view events","create event", "view event requests", "create event request","update event request", "approve event request","create financial request"};
        String[] CSEmployeeAccess = {"view events","create event request","view event requests","create financial request"};
        String[] FManagerAccess = {"view events", "add discount", "update event request","view event requests", "review financial requests"};
        String[] FEmployee1Access = {"view events", "update event request","view event requests"};
        String[] PEmployeeAccess = {"view events","comment on task"};
        String[] PManagerAccess = {"view events","view employee","view client","update event","update event request","view event requests","create financial request","create HR request"};
        String[] SManagerAccess = {"view events","view event requests","update event request","create financial request","create HR request"};
        String[] SEmployeeAccess = {"view events"};
        String[] AdminAccesss = {"view events","create event","edit event", "view employees","edit employees","view clients","edit clients","view event requests","update event request", "approve event request"};
        String[] VPresidentAccesss = {"view events","view employees","edit employees","view clients","edit clients","edit event","view event requests","update event request"};
        String[] SudoAccess = {"view events","create financial request","create HR request", "create event request","add discount", "create financial request","view employees","edit employees","view clients","edit clients","edit event","view event requests","update event request"};

        String[] HREmployeeAccess = {"view events", "review HR requests"};

        accessRights.put("HREmployee",HREmployeeAccess);
        accessRights.put("CSManager",CSManagerAccess);
        accessRights.put("CSEmployee1",CSEmployeeAccess);
        accessRights.put("CSEmployee2",CSEmployeeAccess);
        accessRights.put("FManager",FManagerAccess);
        accessRights.put("FEmployee1",FEmployee1Access);
        accessRights.put("FEmployee2",FEmployee1Access);
        accessRights.put("FEmployee3",FEmployee1Access);
        accessRights.put("FEmployee4",FEmployee1Access);
        accessRights.put("FEmployee5",FEmployee1Access);
        accessRights.put("PEmployee1",PEmployeeAccess);
        accessRights.put("PEmployee2",PEmployeeAccess);
        accessRights.put("PEmployee3",PEmployeeAccess);
        accessRights.put("PEmployee4",PEmployeeAccess);
        accessRights.put("PEmployee5",PEmployeeAccess);
        accessRights.put("PManager",PManagerAccess);
        accessRights.put("SManager",SManagerAccess);
        accessRights.put("SEmployee1",SEmployeeAccess);
        accessRights.put("SEmployee2",SEmployeeAccess);
        accessRights.put("SEmployee3",SEmployeeAccess);
        accessRights.put("SEmployee4",SEmployeeAccess);
        accessRights.put("AEmployee1",AdminAccesss);
        accessRights.put("AEmployee2",AdminAccesss);
        accessRights.put("AEmployee3",AdminAccesss);
        accessRights.put("AEmployee4",AdminAccesss);
        accessRights.put("AManager",AdminAccesss);
        accessRights.put("VPresident",VPresidentAccesss);
        accessRights.put("sudo",SudoAccess);

        /*//Customer Service
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
        userNameToEmployeeID.put("VPresident",9);*/


        employeeData.add(new Employee(1, "CSEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","CSEmployee",true,CSEmployeeAccess));
        employeeData.add(new Employee(2, "CSEmployee2", "8906 Broadway ln, Englewood, Al, 70374"
                , 16, "8749580839","CSEmployee",true,CSEmployeeAccess));
        employeeData.add(new Manager(3, "CSManager", "9827 Broadway ln, Englewood, Al, 70374"
                , 30, "8495837485", "CSManager",true,CSManagerAccess));
        employeeData.add(new Employee(4, "FEmployee1", "803 E Green St,Urbana Il, 61801"
                , 16, "9807867586","FEMployee",false,FEmployee1Access));
        employeeData.add(new Manager(5, "FManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "FManager",false,FManagerAccess));
        //The addresses and phone numbers are the same b/c I didn't want to make more up
        employeeData.add(new Employee(6, "PEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","PEmployee",false,PEmployeeAccess));
        employeeData.add(new Employee(7, "PEmployee2", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","PEmployee",false,PEmployeeAccess));
        employeeData.add(new Employee(8, "PEmployee3", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","PEmployee",false,PEmployeeAccess));
        employeeData.add(new Employee(9, "PEmployee4", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","PEmployee",false,PEmployeeAccess));
        employeeData.add(new Employee(10, "PEmployee5", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","PEmployee",false, PEmployeeAccess));
        employeeData.add(new Manager(11, "PManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "PManager",false,PManagerAccess));
        employeeData.add(new Employee(12, "SEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","SEmployee",false,SEmployeeAccess));
        employeeData.add(new Employee(13, "SEmployee2", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","SEmployee",false,SEmployeeAccess));
        employeeData.add(new Employee(14, "SEmployee3", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","SEmployee",false,SEmployeeAccess));
        employeeData.add(new Employee(15, "SEmployee4", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","SEmployee",false,SEmployeeAccess));
        employeeData.add(new Manager(16, "SManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "SManager",false,SManagerAccess));
        employeeData.add(new Employee(17, "AEmployee1", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","AEmployee",true,AdminAccesss));
        employeeData.add(new Employee(18, "AEmployee2", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","AEmployee",true,AdminAccesss));
        employeeData.add(new Employee(19, "AEmployee3", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","AEmployee",true,AdminAccesss));
        employeeData.add(new Employee(20, "AEmployee4", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","AEmployee",true,AdminAccesss));
        employeeData.add(new Manager(21, "AManager", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "AManager",true,AdminAccesss));
        employeeData.add(new Employee(22, "Secretary", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","Secertary",false,AdminAccesss));
        employeeData.add(new Manager(23, "VPresident", "887 Grand St, Parklang, Wy, 78960"
                , 30, "8765890869", "VPresdent",false,VPresidentAccesss));

        employeeData.add(new Employee(24, "HREmployee", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","HREmployee",true,HREmployeeAccess));

        //for testing
        employeeData.add(new Employee(23, "emp", "11 Johnson street, Deerson Al, 70374"
                , 16, "3035138366","Service",false,SudoAccess));

        employeeCredentials.put("emp","emp");

        employeeCredentials.put("HREmployee","pass");
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

        userNameToEmployeeID.put("emp",23);
        userNameToEmployeeID.put("HREmployee",24);

    }

    public String[] getAccessRights(Employee employee){
       return accessRights.get(employee.getEmployeeType());
    }
    public String getEmployeeCredentials(String userName){
        return employeeCredentials.get(userName.trim());
    }
    public int getEmployeeID(String userName)
    {
        if(!userNameToEmployeeID.containsKey(userName.trim()))
        {
            return 0;
        }
        return userNameToEmployeeID.get(userName.trim());
    }

    public Employee getEmployee(int employeeID)
    {
        if(employeeID > employeeData.size() || employeeID < 0)
        {
            return null;
        }
        return employeeData.get(employeeID-1);
    }



}
