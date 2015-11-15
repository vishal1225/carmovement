package com.car.movement.commands;

import com.car.movement.pojo.Direction;
import com.car.movement.pojo.Position;
import com.car.movement.pojo.IVehicle;

/**
 * Created by Vishal on 14-11-2015.
 */
public class TurnLeftCommand implements ICommand{

    @Override
    public void execute(IVehicle vehicle) {
        Position vehiclePosition=vehicle.getPosition();
        if(vehiclePosition.getFacing().equals(Direction.EAST)){
            vehiclePosition.setFacing(Direction.NORTH);
        }
        else if(vehiclePosition.getFacing().equals(Direction.NORTH)){
            vehiclePosition.setFacing(Direction.WEST);
        }
        else if(vehiclePosition.getFacing().equals(Direction.WEST)){
            vehiclePosition.setFacing(Direction.SOUTH);
        }
        else if(vehiclePosition.getFacing().equals(Direction.SOUTH)){
            vehiclePosition.setFacing(Direction.EAST);
        }
    }
}
