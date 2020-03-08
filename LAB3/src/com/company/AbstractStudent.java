package com.company;

abstract class AbstractStudent {
    private String name;
    private String surname;

    public AbstractStudent(){;}
    public AbstractStudent(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

}
