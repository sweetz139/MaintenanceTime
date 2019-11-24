package com.MaintenanceTime.MaintenanceTime.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;

@Entity
public class Task {

    @NotNull
    @Size(min=3,max=25)
    private String name;

    // creates a calendar instance
    private Calendar calendar = Calendar.getInstance();

    private java.util.Date now = calendar.getTime();

    private java.sql.Timestamp currentTimeStamp = new java.sql.Timestamp(now.getTime());

   // private int interval;

   /* public java.sql.Timestamp addTime(int interval, String unit){
        if(unit.equals("years")){
            System.out.println("add some code here");
        }

        return
    }*/

   // Calendar time =  (calendar.add(Calendar.DAY_OF_MONTH, 2))

    //@NotNull
    //private Date startingPeriod;

    //@NotNull
    //private Date endingPeriod;

    @NotNull
    private int occurence;

    @NotNull
    private String unit;  // could be day,week,month or year

    @NotNull
    @Size(min=3,max =240)
    private String description;

    private Date dueDate;

    @Id
    @GeneratedValue
    private int id;

    public int getId(){return this.id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}


    public void Task(){}

    public void Task(String name, String description){
        this.name = name;
        this.description = description;


    }

    public Timestamp getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    /*public int getInterval() {
        return interval;
    }*/

    /*public void setInterval(int interval) {
        this.interval = interval;
    }*/

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }
}
