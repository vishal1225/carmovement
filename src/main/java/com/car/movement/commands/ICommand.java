package com.car.movement.commands;

import com.car.movement.pojo.IVehicle;
import com.car.movement.util.ResourceUtil;

/**
 * Created by Pooja on 14-11-2015.
 */
public interface ICommand {
	static int MAX_Y=Integer.parseInt(ResourceUtil.getPropertyValue("max.y"));
	static int MAX_X=Integer.parseInt(ResourceUtil.getPropertyValue("max.x"));
	static int MIN_X=Integer.parseInt(ResourceUtil.getPropertyValue("min.x"));
	static int MIN_Y=Integer.parseInt(ResourceUtil.getPropertyValue("min.y"));
    public void execute(IVehicle vehicle)throws Exception;
}
