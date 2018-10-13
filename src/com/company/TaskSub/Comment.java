package com.company.TaskSub;

public class Comment {
    private String comment;
    private int employeeID;

    public void setEmployeeID(int employeeID){
        this.employeeID=employeeID;
    }
    public int getEmployeeID(){
        return employeeID;
    }
    public void setComment(String comment){
        this.comment=comment;
    }
    public String getComment(){
        return comment;
    }
}
