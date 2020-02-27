package com.company;

public class Lecture extends Exercise{
    private String topic = new String();

    public Lecture(){;}

    public Lecture(String topic,String date){

        this.topic = topic;
        this.date = date;
    }

    public void setLecture (String newTopic,String newData){
        this.date = newData;
        this.topic = newTopic;
    }

    public String getTopic (){
        return this.topic;
    }
    public String getDate () {
        return this.date;
    }

}
