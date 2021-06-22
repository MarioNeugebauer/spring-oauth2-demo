package org.htwdresden.informatik.pkademo.springoauth2demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike {

    // IDENTITY ... it's the job of the database to assign the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String frameNumber;
    private Integer wheelSizeInch;
    private Integer frameSize;

    protected Bike() {}

    public Bike(String type, String frameNumber, Integer wheelSizeInch, Integer frameSize) {
        this.type = type;
        this.frameNumber = frameNumber;
        this.wheelSizeInch = wheelSizeInch;
        this.frameSize = frameSize;
    }

    public Bike(String type, String frameNumber) {
        this.type = type;
        this.frameNumber = frameNumber;
    }

    @Override
    public String toString() {
        return String.format("Bike[id=%d,type=%s,frameNumber=%s,wheelSizeInch=%d,frameSize=%d]",id,type,frameNumber,wheelSizeInch,frameSize);
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public Integer getWheelSizeInch() {
        return wheelSizeInch;
    }

    public Integer getFrameSize() {
        return frameSize;
    }

}

