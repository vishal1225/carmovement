package com.car.movement.pojo;

import java.util.List;

/**
 * Created by Vishal on 13-11-2015.
 */
public class Car implements IVehicle {
    private Position position;

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Position position) {
		this.position=position;
		
	}
}
