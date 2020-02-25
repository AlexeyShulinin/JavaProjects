package com.company;

public class Lecture {
    private String topic = new String();

    public Lecture(){;}

    public Lecture(String topic){
        this.topic = topic;
    }

    public void setTopic (String newTopic){
        this.topic = newTopic;
    }

    public String getTopic (){
        return this.topic;
    }

}
