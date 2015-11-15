package com.car.movement.commands;

import com.car.movement.pojo.Position;
import com.car.movement.pojo.IVehicle;

/**
 * Created by Vishal on 14-11-2015.
 */
public class InitCommand implements ICommand{
    Position initPosition;
    public InitCommand(Position position) {
	   this.initPosition=position;
    }
    @Override
    public void execute(IVehicle vehicle) throws Exception {
    	if(initPosition.getX()<=MAX_X && initPosition.getX()>=MIN_X && initPosition.getY()>=MIN_Y && initPosition.getY()<=MAX_Y){
    		vehicle.setPosition(initPosition);
    	}
    	else{
    		throw new Exception("Game Over car is out of grid");
    	}
        
    }
}
