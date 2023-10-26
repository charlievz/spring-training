package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

// import jakarta.annotation.PostConstruct;
// import jakarta.annotation.PreDestroy;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach) { 
    // @Qualifier("trackCoach") Coach anotherCoach) {
        System.out.println("In constructor " + this.getClass().getSimpleName() + "!!!!!!!!!!!!");
        this.myCoach = theCoach;
        // this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    // @GetMapping("/check")
    // public String check() {
    //     return "Comparing beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    // }

    // Demonstrating setter injection
    // @Autowired
    // public void doSomeStuff(Coach theCoach) {
    //     myCoach = theCoach;
    // }
}
