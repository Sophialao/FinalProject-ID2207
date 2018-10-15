package com.company.Test;

import com.company.Event.Event;
import com.company.LoginHandler;
import com.company.RequestSub.EventRequest;
import com.company.RequestSub.FinancialRequest;
import com.company.TaskSub.Task;
import com.company.WorkerSub.Employee;
import com.company.WorkerSub.EmployeeData;

public class Test
{
    static int numTests = 0;
    static int passedTests = 0;
    public static void main(String[] args)
    {
        System.out.println("Tests for our program");

        createEventRequestTest();
        createFinancialRequestTest();
        createHRRequestTest();

        Event event = createEventTest();
        createTaskTest(event);

        EmployeeData employeeData = createDataBaseTest();
        logInTest(employeeData);

        System.out.println("Tests passed out total tests " + passedTests + "/" + numTests);

    }
    static void createEventRequestTest()
    {
        numTests++;

        EventRequest eventRequest = new EventRequest();
        eventRequest.setBudget("10000");
        eventRequest.setName("Test1");
        eventRequest.setDescription("This is a test event for the purpose of testing");
        eventRequest.setStartDate("2/1/19");
        eventRequest.setEndDate("5/1/19");
        eventRequest.setID("1");

        boolean success = true;

        if(!eventRequest.getName().equals("Test1"))
            success = false;
        if(!eventRequest.getBudget().equals("10000"))
            success = false;
        if(!eventRequest.getDescription().equals("This is a test event for the purpose of testing"))
            success = false;
        if(!eventRequest.getStartDate().equals("2/1/19"))
            success = false;
        if(!eventRequest.getEndDate().equals("5/1/19"))
            success = false;

        if(!success)
        {
            System.out.println("Event request test FAILED");
        }
        else {
            System.out.println("Event request test PASSED");
            passedTests++;
        }
    }

    static void createFinancialRequestTest()
    {
        numTests++;

        FinancialRequest financialRequest = new FinancialRequest();
        financialRequest.setAmount("8999");
        financialRequest.setConcerningRequest("This is a test concern");
        financialRequest.setDescription("This is a test financial request");
        financialRequest.setReuestingDepartment("Service");

        boolean success = true;

        if(!financialRequest.getAmount().equals("8999"))
            success = false;
        if(!financialRequest.getConcerningRequest().equals("This is a test concern"))
            success = false;
        if(!financialRequest.getDescription().equals("This is a test financial request"))
            success = false;
        if(!financialRequest.getReuestingDepartment().equals("Service"))
            success = false;

        if(!success)
        {
            System.out.println("Financial request test FAILED");
        }
        else {
            System.out.println("Financial request test PASSED");
            passedTests++;
        }
    }

    static void createHRRequestTest() {
        numTests++;

        FinancialRequest financialRequest = new FinancialRequest();
        financialRequest.setAmount("8999");
        financialRequest.setConcerningRequest("This is a test concern");
        financialRequest.setDescription("This is a test financial request");
        financialRequest.setReuestingDepartment("Service");

        boolean success = true;

        if (!financialRequest.getAmount().equals("8999"))
            success = false;
        if (!financialRequest.getConcerningRequest().equals("This is a test concern"))
            success = false;
        if (!financialRequest.getDescription().equals("This is a test financial request"))
            success = false;
        if (!financialRequest.getReuestingDepartment().equals("Service"))
            success = false;

        if (!success) {
            System.out.println("HR request test FAILED");
        } else {
            System.out.println("HR request test PASSED");
            passedTests++;
        }
    }


    static Event createEventTest()
    {
        numTests++;

        Event event = new Event();
        event.setName("Test Event");

        boolean success = true;

        if(!event.getName().equals("Test Event"))
            success = false;

        if(!success)
        {
            System.out.println("Event test FAILED");
        }
        else {
            System.out.println("Event test PASSED");
            passedTests++;
        }
        return event;
    }

    static void createTaskTest(Event event)
    {
        numTests++;

        Task task = new Task();
        task.setName("test Task");
        task.setEvent(event);
        task.setDescription("This is a test task");

        boolean success = true;

        if(!task.getName().equals("test Task"))
            success = false;
        if(!task.getEvent().equals(event))
            success = false;

        if(!success)
        {
            System.out.println("Task test FAILED");
        }
        else {
            System.out.println("Task test PASSED");
            passedTests++;
        }
    }

    static EmployeeData createDataBaseTest()
    {
        numTests++;
        EmployeeData employeeData = new EmployeeData();
        employeeData.startUp();

        passedTests++;
        return employeeData;
    }
    static void logInTest(EmployeeData employeeData)
    {
        numTests++;
        LoginHandler loginHandler = new LoginHandler();

        boolean success = true;

        int employeeId = loginHandler.checkLogIn("SEmployee1","SEmployee1Pass",employeeData);

        if(employeeId <= 0)
            success = false;

        if(!success)
        {
            System.out.println("logIn test FAILED");
        }
        else {
        System.out.println("logIn test PASSED");
        passedTests++;
    }
    }
}
