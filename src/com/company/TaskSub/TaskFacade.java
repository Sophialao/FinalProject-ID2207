package com.company.TaskSub;

import com.company.Event.Event;
import com.company.WorkerSub.EmployeeData;

public class TaskFacade
{
    TaskHandler taskHandler = new TaskHandler();

    public void createTask(Event event, EmployeeData employeeData,boolean SManager, boolean PManager) {
        taskHandler.createTask(event,employeeData,SManager,PManager);
    }
    //manager refers only to PManager and SManager since they can view all tasks
    public void viewTasks(Event event,int employeeID,boolean SManager, boolean PManager) {
        taskHandler.viewTasks(event,employeeID,SManager,PManager);
    }
}
