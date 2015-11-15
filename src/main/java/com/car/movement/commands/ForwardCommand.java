package com.car.movement.commands;

import com.car.movement.pojo.Direction;
import com.car.movement.pojo.Position;
import com.car.movement.pojo.IVehicle;
import com.car.movement.util.ResourceUtil;

/**
 * Created by Pooja on 14-11-2015.
 */
public class ForwardCommand implements ICommand {
	
    @Override
    public void execute(IVehicle vehicle) throws Exception {
        Position vehiclePosition=vehicle.getPosition();
        if(vehiclePosition.getFacing().equals(Direction.EAST)){
        	if(vehiclePosition.getY()+1 < MAX_Y){
        		vehiclePosition.setY(vehiclePosition.getY()+1);
        	}
        	else{
        		throw new Exception("Game Over car is out of grid");
        	}
        }
        else if(vehiclePosition.getFacing().equals(Direction.NORTH)){
            if(vehiclePosition.getX()+1<MAX_X){
            	vehiclePosition.setX(vehiclePosition.getX()+1);
            }
            else{
        		throw new Exception("Game Over car is out of grid");
        	}
        }
        else if(vehiclePosition.getFacing().equals(Direction.WEST)){
            if(vehiclePosition.getY()-1 > MIN_Y){
            	vehiclePosition.setY(vehiclePosition.getY()-1);
            }
            else{
        		throw new Exception("Game Over car is out of grid");
        	}

        }
        else if(vehiclePosition.getFacing().equals(Direction.SOUTH)){
            if(vehiclePosition.getX()-1>MIN_X){
            	vehiclePosition.setX(vehiclePosition.getX()-1);            	
            }
            else{
        		throw new Exception("Game Over car is out of grid");
        	}
        }
    }
}
