package com.company.TaskSub;

import com.company.Event.Event;
import com.company.WorkerSub.Employee;
import com.company.WorkerSub.EmployeeData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TaskHandler
{
    public void createTask(Event event, EmployeeData employeeData,boolean SManager,boolean PManager)
    {
        System.out.println("---CREATE NEW TASK---");
        Task task = new Task();
        Task t = fillInTask(task,employeeData,event,SManager,PManager);

        if(t == null)
        {
            return;
        }
        event.addTaskToEmployee(t.getEmployee().getEmployeeID(),t,SManager,PManager);
        //storeEvent(e);
        System.out.println("Task -"+t.getName()+ "- created! \n");
    }

    private Task fillInTask(Task task, EmployeeData employeeData,Event event,boolean SManager, boolean PManager)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Task name: ");
        String name=s.nextLine();
        task.setName(name);
        int employeeID = 0;
        Employee employee = null;

        while(employee == null) {
            System.out.print("Employee to assign to task: ");
            String employeeName = s.nextLine();
            employeeID = employeeData.getEmployeeID(employeeName);

            while (employeeID == 0) {
                System.out.print("Employee not recognized, please retype employee name: ");
                employeeName = s.nextLine();
                employeeID = employeeData.getEmployeeID(employeeName);
            }
            employee = employeeData.getEmployee(employeeID);

            if (SManager) {
                if (!employee.getEmployeeType().equals("SEmployee")) {
                    System.out.println("No permission to assign task to " + employeeName);
                    employee = null;
                }
            } else if (PManager) {
                if (!employee.getEmployeeType().equals("PEmployee")) {
                    System.out.println("No permission to assign  task to " + employeeName);
                    employee = null;
                }
            }
        }

        task.setEmployee(employee);
        task.setEvent(event);
        //clearing the buffer of the scanner
        //if(s.hasNext()) { s.next(); }
        System.out.print("Task Description: ");
        String description=s.next();
        task.setDescription(description);

        return task;
    }

    public void viewTasks(Event event,int employeeID,boolean SManager,boolean PManager)
    {
       if(SManager || PManager)
       {

           //Iterator<ArrayList<Task>> iterator = event.getAllTasks(SManager,PManager);
            ArrayList<Task> arrayList = event.getAllTasks(SManager,PManager);

           if(arrayList.isEmpty())
           {
               System.out.println("There are currently no tasks for this event\n");
               return;
           }

           System.out.println("---VIEW TASKS---");
           for(Task t: arrayList)
           {
               System.out.println("Assigned to " + t.getEmployee().getName() + "-" + t.getName() + ": " + t.getDescription());
           }

       }
       else {
           ArrayList<Task> tasks = event.getTasks(employeeID);
           if(tasks == null || tasks.isEmpty())
           {
               System.out.println("You don't currently have any tasks for this event\n");
               return;
           }
           System.out.println("---YOUR TASKS---");
           for (Task t : tasks) {
               System.out.println(t.getName() + ": " + t.getDescription());
           }
       }
    }
}
