package com.anand.database.databasedemo.entity;

import java.util.Date;

public class PersonJdbc {
    private int id;
    private String name;
    private String location;
    private Date birthDate;

    //private Date birthDateDummy;

    public PersonJdbc() {
    }

    public PersonJdbc(int id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*public Date getBirthDate() {
        return birthDate2;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate2 = birthDate;
    }
*/

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

}
