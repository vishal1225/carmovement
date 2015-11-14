package com.vishal.main;

import com.vishal.io.ReadFileData;

/**
 * Hello world!
 *
 */
public class App

{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ReadFileData readFileData = new ReadFileData();
        try{
            readFileData.readFromFile();
        }
        catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
    }
}
