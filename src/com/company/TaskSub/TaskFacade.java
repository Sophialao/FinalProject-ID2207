package com.company.TaskSub;

import com.company.Event.Event;
import com.company.WorkerSub.Employee;
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
    public void viewOwnTasks(Event ev,int empID){
        taskHandler.viewOwnTasks(ev,empID);
    }
    public void addCommentToTask( int empID, Event ev){
        taskHandler.addCommentToTask(empID,ev);
    }
    public void startUp(Employee empl,Event testEvent){
        taskHandler.startUp(empl,testEvent);
    }
}
