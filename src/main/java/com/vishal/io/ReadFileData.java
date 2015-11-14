package com.vishal.io;


import com.vishal.Command;
import com.vishal.Direction;
import com.vishal.beans.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.vishal.Command.INIT;

public class ReadFileData {
    private final int xCordinate = 5;
    private final int yCordinate = 5;

    public void readFromFile() throws IllegalArgumentException{
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\testing.txt"))) {

            String sCurrentLine;
            List<Command> commandList = new ArrayList<>();
            List<Position> positionList = new ArrayList<Position>();

            while ((sCurrentLine = br.readLine()) != null) {
                final String[] split = sCurrentLine.split("\\s*(,|\\s)");
                if (commandList.isEmpty()) {
                    if (checkValidInitCommand(split)) {
                        commandList.add(Command.valueOf(split[0]));
                        positionList.add(createPosition(split));
                    }
                    //Discard any command other than initial INIT
                    else {
                        continue;
                    }
                } else {
                    if(split.length == 1){
                        commandList.add(Command.valueOf(split[0]));
                    }
                    else if (checkValidInitCommand(split)) {
                        commandList.add(Command.valueOf(split[0]));
                        positionList.add(createPosition(split));
                    }
                    else{
                        // seems to be an invalid command. Ignore it
                        continue;
                    }
                }
            }
            for(Command c : commandList){
                System.out.println(c.getCommandType());
            }for(Position c :positionList ){
                System.out.println(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


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
}
