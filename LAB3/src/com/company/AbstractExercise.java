package com.company;

abstract class AbstractExercise {
    private String date;

    public AbstractExercise(){;}
    public AbstractExercise(String date){
        this.date = date;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }

}
