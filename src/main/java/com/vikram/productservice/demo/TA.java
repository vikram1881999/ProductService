package com.vikram.productservice.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue( value = "3" )
public class TA extends User{
    private int noOfSessions;
    private double avgRating;

    public int getNoOfSessions() {
        return noOfSessions;
    }

    public void setNoOfSessions(int noOfSessions) {
        this.noOfSessions = noOfSessions;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
