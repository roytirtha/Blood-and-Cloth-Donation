package com.practice.bacd;

public class Userinformation {

    public String id;
    public String name;
    public String location;
    public String bloodgroup;
    public String contactNo;

    public Userinformation(){

    }

    public Userinformation(String id, String name, String location, String bloodgroup, String contactNo) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.bloodgroup = bloodgroup;
        this.contactNo = contactNo;
    }

    public String getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getLocation() {

        return location;
    }

    public String getBloodgroup()
    {
        return bloodgroup;
    }

    public String getContactNo() {

        return contactNo;
    }
}
