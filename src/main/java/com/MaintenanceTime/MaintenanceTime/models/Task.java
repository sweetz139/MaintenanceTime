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
@Table(name="task")
public class Task {

    @NotNull
    @Size(min=3,max=25)
    private String name;

    // creates a calendar instance
    private Calendar calendar = Calendar.getInstance();

    private Calendar new_calendar = Calendar.getInstance();

    private java.util.Date now = calendar.getTime();

    private java.sql.Timestamp currentTimeStamp = new java.sql.Timestamp(now.getTime());

    //private java.sql.Date dueDateTimeStamp = new java.sql.Date(this.dueDate.getTime());

   // private int interval;

    /*public void  addTime(int occurence, String unit){
        if(unit.equals("year")){
             new_calendar.add(Calendar.YEAR,occurence);
        }
        else if(unit.equals("month")){
            new_calendar.add(Calendar.MONTH,occurence);
        }
        else if(unit.equals("week")){
            new_calendar.add(Calendar.WEEK_OF_MONTH,occurence);
        }
        else if(unit.equals("day")){
            new_calendar.add(Calendar.DATE,occurence);
        }


    }*/

    @NotNull
    private int occurence;

    @NotNull
    private String unit;  // could be day,week,month or year

    @NotNull
    @Size(min=3,max =240)
    private String description;

    //private Date dueDate = new_calendar.getTime();
      private Date dueDate;

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;


    public int getId(){
         return this.id;
    }

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

    public Date getDueDate(){
        return this.dueDate;
    }

    /*public void setDueDate(String unit, int occurence){
        if(unit.equals("year")){
            this.dueDate = new_calendar.set()
        }
    }*/
}
