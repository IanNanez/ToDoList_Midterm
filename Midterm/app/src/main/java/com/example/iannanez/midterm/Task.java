package com.example.iannanez.midterm;


import java.util.Comparator;
/**
 * Created by iannanez on 3/7/17.
 */

public class Task implements Comparable<Task>{

    private int priority;
    private String title;
    private String description;
    private boolean complete;

    public Task(int p, String t, String d){
        priority = p;
        title = t;
        description = d;
        complete = false;
    }

    public int getPriority(){
        return priority;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void changeComplete() {
        this.complete = !this.complete;
    }

    public int compareTo(Task other){
        if(this.priority == other.getPriority()){
            return 0;
        }
        if(this.priority > other.getPriority()){
            return 1;
        }
        return -1;


    }




}
