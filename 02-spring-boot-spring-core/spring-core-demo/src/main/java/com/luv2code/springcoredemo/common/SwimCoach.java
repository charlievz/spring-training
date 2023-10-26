package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        // TODO Auto-generated method stub
        return "Swim three laps a day";
    }
    
}
