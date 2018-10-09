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
    public void createTask(Event event, EmployeeData employeeData)
    {
        System.out.println("---CREATE NEW TASK---");
        Task task = new Task();
        Task t = fillInTask(task,employeeData,event);

        if(t == null)
        {
            return;
        }
        event.addTaskToEmployee(t.getEmployee().getEmployeeID(),t);
        //storeEvent(e);
        System.out.println("Task -"+t.getName()+ "- created! ");
    }

    private Task fillInTask(Task task, EmployeeData employeeData,Event event)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Task name: ");
        String name=s.nextLine();
        task.setName(name);
        System.out.print("EmployeeID: ");
        if(!s.hasNextInt())
        {
            System.out.println("invalid input");
            return null;
        }
        int employeeID = s.nextInt();
        Employee employee = employeeData.getEmployee(employeeID);
        //TODO check validaty of the employee!
        task.setEmployee(employee);
        task.setEvent(event);
        //clearing the buffer of the scanner
        //if(s.hasNext()) { s.next(); }
        System.out.print("Task Description: ");
        String description=s.next();
        task.setDescription(description);

        return task;
    }

    public void viewTasks(Event event,int employeeID,boolean manager)
    {
       if(manager)
       {
           Iterator<ArrayList<Task>> iterator = event.getAllTasks();

           if(!iterator.hasNext())
           {
               System.out.println("There are currently no tasks for this event");
               return;
           }

           System.out.println("---VIEW TASKS---");
           while(iterator.hasNext())
           {
               ArrayList<Task> arrayList = iterator.next();
               for(Task t: arrayList)
               {
                   System.out.println(t.getName() + ": " + t.getDescription());
               }
           }

       }
       else {
           ArrayList<Task> tasks = event.getTasks(employeeID);
           if(tasks.isEmpty())
           {
               System.out.println("You don't currently have any tasks for this event");
               return;
           }
           System.out.println("---YOUR TASKS---");
           for (Task t : tasks) {
               System.out.println(t.getName() + ": " + t.getDescription());
           }
       }
    }
}
