package com.company.TaskSub;

import com.company.Event.Event;
import com.company.WorkerSub.EmployeeData;

public class TaskFacade
{
    TaskHandler taskHandler = new TaskHandler();

    public void createTask(Event event, EmployeeData employeeData) {
        taskHandler.createTask(event,employeeData);
    }
    //manager refers only to PManager and SManager since they can view all tasks
    public void viewTasks(Event event,int employeeID,boolean manager) {
        taskHandler.viewTasks(event,employeeID,manager);
    }
}
