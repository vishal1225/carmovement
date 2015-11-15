package com.car.movement.command.reader.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.car.movement.command.reader.ReadCommandFromFile;
import com.car.movement.commands.ICommand;
import com.car.movement.pojo.Car;
import com.car.movement.pojo.IVehicle;

import junit.framework.TestCase;

public class ReadCommandsFromFileTest extends TestCase {
	public void testReadFromFile() throws Exception {
		ReadCommandFromFile readFileData = new ReadCommandFromFile();
		List<ICommand> commandList = null;
		IVehicle vehicle = new Car();
		File file=new File(ReadCommandFromFile.class.getClassLoader().getResource("testing.txt").toURI());
		commandList = readFileData
				.readFromFile(file);
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String sCurrentLine;
		int lineCount=0;
		while ((sCurrentLine = reader.readLine()) != null) {
			lineCount++;
		}
		assertNotNull(commandList);
		assertTrue(commandList.size()==lineCount-1);
	}
}
