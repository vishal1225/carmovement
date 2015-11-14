package com.vishal.beans;

import com.vishal.Direction;

/**
 * Created by Vishal on 12-11-2015.
 */
public class Position {
    private int x;
    private int y;
    private Direction facing;

    public Position() {
    }

    public Position(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
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
