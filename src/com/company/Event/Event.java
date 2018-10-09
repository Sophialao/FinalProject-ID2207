package com.company.Event;

import com.company.TaskSub.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Event {

    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private String budget;
    private String feedback;

    private HashMap<Integer, ArrayList<Task>> taskByEmployeeId = new HashMap<>();

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setStartDate(String date){
        this.startDate=date;
    }
    public String getStartDate(){
        return startDate;
    }

    public void setEndDate(String date){
        this.endDate=date;
    }
    public String getEndDate(){
        return endDate;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }

    public void setBudget(String budget){
        this.budget=budget;
    }
    public String getBudget(){
        return budget;
    }


    public void addTaskToEmployee(int employeeId,Task task)
    {
        ArrayList arrayList = taskByEmployeeId.get(employeeId);
        if(arrayList == null)
        {
            arrayList = new ArrayList<Task>();
        }
        arrayList.add(task);
        //Is it necessary to put back in...??
        taskByEmployeeId.put(employeeId,arrayList);
    }
    public ArrayList<Task> getTasks(int employeeId)
    {
        return taskByEmployeeId.get(employeeId);
    }
    public Iterator<ArrayList<Task>> getAllTasks()
    {
        Collection<ArrayList<Task>> collection = taskByEmployeeId.values();
        Iterator<ArrayList<Task>> iterator = collection.iterator();
        return iterator;
    }

}
