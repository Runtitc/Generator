package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Przemix on 10/6/16.
 */
public class FileListGenerator implements Runnable{
    private String fileName;
    private ArrayList options;
    private String program;
    private String directory;
    private String command;

    public FileListGenerator(String program, ArrayList options, String directory, String fileName){
        this.program    = program;
        this.options    = options;

        this.fileName   = fileName;

        this.directory  = directory;
        this.command    = program + " " + directory;
    }
    @Override
    public void run(){
        String line = null;

        try {
            Process currentProgram = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(
                    new InputStreamReader(currentProgram.getInputStream()));

            BufferedReader stdError = new BufferedReader(
                    new InputStreamReader(currentProgram.getErrorStream()));

            while ((line = stdInput.readLine()) != null){
                System.out.println(line);
            }

            while ((line = stdError.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}