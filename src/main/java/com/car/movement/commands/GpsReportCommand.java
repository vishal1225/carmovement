package com.car.movement.commands;

import com.car.movement.pojo.Direction;
import com.car.movement.pojo.Position;
import com.car.movement.pojo.IVehicle;

/**
 */
public class GpsReportCommand implements ICommand {
    @Override
    public void execute(IVehicle vehicle) {
        Position vehiclePosition=vehicle.getPosition();
        System.out.println("coordinate x and y:" +vehiclePosition.getX()+", "+vehiclePosition.getY());
        System.out.println("Moving towards: "+vehiclePosition.getFacing());
    }
}
