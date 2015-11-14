package com.car.movement.command.reader;

import static com.car.movement.pojo.Command.INIT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.car.movement.command.executer.ExecuteCommand;
import com.car.movement.commands.ForwardCommand;
import com.car.movement.commands.GpsReportCommand;
import com.car.movement.commands.ICommand;
import com.car.movement.commands.InitCommand;
import com.car.movement.commands.TurnLeftCommand;
import com.car.movement.commands.TurnRightCommand;
import com.car.movement.pojo.Car;
import com.car.movement.pojo.Command;
import com.car.movement.pojo.Direction;
import com.car.movement.pojo.Position;
import com.car.movement.pojo.IVehicle;

public class ReadCommandFromFile {
	private final int xCordinate = 5;
	private final int yCordinate = 5;

	public List<ICommand> readFromFile(File file) throws Exception {

		List<ICommand> commandList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			final String[] split = sCurrentLine.split("\\s*(,|\\s)");
			if (commandList.isEmpty()) {
				if (checkValidInitCommand(split)) {
					commandList.add(new InitCommand(createPosition(split)));
				}
				// Discard any command other than initial INIT
				else {
					continue;
				}
			} else {
				if (split.length == 1) {
					commandList.add(identifyCommand(Command.valueOf(split[0])));
				} else if (checkValidInitCommand(split)) {
					commandList.add(new InitCommand(createPosition(split)));
				} else {
					// seems to be an invalid command. Ignore it
					continue;
				}
			}
		}
		return commandList;
	}

	private Position createPosition(String[] split) {
		int x = Integer.parseInt(split[1]);
		int y = Integer.parseInt(split[2]);
		Direction direction = Direction.valueOf(split[3]);
		return new Position(x, y, direction);
	}

	private boolean checkValidInitCommand(String[] split) {
		if ((Command.valueOf(split[0]).equals(INIT)) && (split.length == 4)) {
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			Direction direction = Direction.valueOf(split[3]);
			if ((x >= 0 && x < xCordinate) && (y >= 0 && y < yCordinate)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private ICommand identifyCommand(Command command) {
		ICommand concreteCommand = null;
		if (command.equals(Command.FORWARD)) {
			concreteCommand = new ForwardCommand();
		}
		if (command.equals(Command.TURN_LEFT)) {
			concreteCommand = new TurnLeftCommand();
		}
		if (command.equals(Command.TURN_RIGHT)) {
			concreteCommand = new TurnRightCommand();
		}
		if (command.equals(Command.GPS_REPORT)) {
			concreteCommand = new GpsReportCommand();
		}
		return concreteCommand;
	}

	public static void main(String[] args) throws Exception {
		ReadCommandFromFile readFileData = new ReadCommandFromFile();
		IVehicle iVehicle=new Car();
		try {
			List<ICommand> commandList=readFileData.readFromFile(
					new File(ReadCommandFromFile.class.getClassLoader().getResource("testing.txt").toURI()));
			ExecuteCommand.execute(commandList, iVehicle);
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
		}
	}
}
