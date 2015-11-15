package com.car.movement.command.executer;

import java.util.List;

import com.car.movement.commands.ICommand;
import com.car.movement.pojo.IVehicle;

public class ExecuteCommand {

    public static void execute(List<ICommand> commandList, IVehicle vehicle) throws Exception{
            for(ICommand command:commandList){
                command.execute(vehicle);
            }
    }
}
