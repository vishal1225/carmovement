package com.vishal;

import com.vishal.beans.Position;

import java.util.List;

/**
 * Created by Vishal on 13-11-2015.
 */
public class Car implements Vehicles, Transit {
    private String color = "Red";
    private Position currentPosition;
    private List<Position> positionsFromInputList;
    private List<Command> positionsFromCommandList;


    public Car() {
    }

    @Override
    public void move() {

    }

    @Override
    public void hasPosition() {
        Position currentPos = getCurrentPosition();
        System.out.println("Current position is"+ currentPos.getX()+ " ,"+ currentPos.getY()
        + " ,"+ currentPos.getFacing());
    }

    @Override
    public void hasColor() {
        System.out.println("Hi, I am a car and my color is " +getColor());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}
