/*
 * Initial driver class to test code
 */
package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Welcome to the Swedish Event Planners online system! \n" +
                "Please log in!");

        EmployeeController employeeController = new EmployeeController();
        employeeController.startUp();

        int employeeID = logIn(employeeController);
        //boolean loggedIn = false;
        while(employeeID == 0)
        {
            employeeID = logIn(employeeController);
        }

        Employee employee = employeeController.getEmployee(employeeID);

        System.out.println("Welcome " + employee.getName());

        employeeController.showActions(employee);
    }

    //should this be moved into a log in controller class?
    public static int logIn(EmployeeController employeeController)
    {
        System.out.print("UserName: ");
        Scanner s = new Scanner(System.in);
        String userName = s.nextLine();
        System.out.print("Password: ");
        String password = s.nextLine();

        return employeeController.checkLogIn(userName,password);
    }
}
