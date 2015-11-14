package com.car.movement.pojo;

/**
 * Created by Vishal on 12-11-2015.
 */
public enum Command {
	INIT("INIT"), FORWARD("FORWARD"), TURN_LEFT("TURN_LEFT"), TURN_RIGHT("TURN_RIGHT"), GPS_REPORT("GPS_REPORT");
	private String commandType;

	private Command(String cType) {
		commandType = cType;

	}

	public String getCommandType() {
		return commandType;
	}
}
