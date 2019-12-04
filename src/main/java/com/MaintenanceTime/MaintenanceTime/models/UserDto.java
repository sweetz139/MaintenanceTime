package com.MaintenanceTime.MaintenanceTime.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserDto {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;
    private String matchingPassword;

    @NotNull
    private String email;


    public void UserDto(){}


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setUsername(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){ return lastName;}

    public void setLastName(String lastName){ this.lastName = lastName;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword(){return this.matchingPassword;}

    public void setMatchingPassword(String matchingPassword){this.matchingPassword = matchingPassword;}

    public String getEmail(){return this.email;}

    public void setEmail(String email){this.email = email;}
}
