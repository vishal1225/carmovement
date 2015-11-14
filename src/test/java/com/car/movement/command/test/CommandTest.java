package com.car.movement.command.test;

import com.car.movement.commands.ForwardCommand;
import com.car.movement.commands.ICommand;
import com.car.movement.commands.InitCommand;
import com.car.movement.commands.TurnLeftCommand;
import com.car.movement.commands.TurnRightCommand;
import com.car.movement.pojo.Car;
import com.car.movement.pojo.Direction;
import com.car.movement.pojo.Position;
import com.car.movement.pojo.IVehicle;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class CommandTest extends TestCase {
	IVehicle vehicle = new Car();

	public void testInitCommand() throws Exception {
		ICommand command = new InitCommand(new Position(0, 0, Direction.NORTH));
		command.execute(vehicle);
		assertTrue(vehicle.getPosition().getX() == 0);
		assertTrue(vehicle.getPosition().getY() == 0);
		assertTrue(vehicle.getPosition().getFacing() == Direction.NORTH);
	}

	public void testForwardCommand() throws Exception {
		ICommand command = new InitCommand(new Position(0, 0, Direction.NORTH));
		command.execute(vehicle);
		command = new ForwardCommand();
		command.execute(vehicle);
		assertTrue(vehicle.getPosition().getX() == 1);
		assertTrue(vehicle.getPosition().getY() == 0);
		assertTrue(vehicle.getPosition().getFacing() == Direction.NORTH);
	}

	public void testTurnLeftCommand() throws Exception {
		ICommand command = new InitCommand(new Position(0, 0, Direction.NORTH));
		command.execute(vehicle);
		command = new TurnLeftCommand();
		command.execute(vehicle);
		assertTrue(vehicle.getPosition().getX() == 0);
		assertTrue(vehicle.getPosition().getY() == 0);
		assertTrue(vehicle.getPosition().getFacing() == Direction.WEST);
	}

	public void testTurnRightCommand() throws Exception {
		ICommand command = new InitCommand(new Position(0, 0, Direction.NORTH));
		command.execute(vehicle);
		command = new TurnRightCommand();
		command.execute(vehicle);
		assertTrue(vehicle.getPosition().getX() == 0);
		assertTrue(vehicle.getPosition().getY() == 0);
		assertTrue(vehicle.getPosition().getFacing() == Direction.EAST);
	}
}
