package com.car.movement.pojo;

/**
 * Created by Vishal on 12-11-2015.
 */
public class Position {
    private int x;
    private int y;
    private Direction facing;


    public Position(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x=x;
    }
    public void setY(int y) {
        this.y=y;
    }
    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction direction) {
        this.facing=direction;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", facing=" + facing +
                '}';
    }
}
