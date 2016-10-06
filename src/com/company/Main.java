package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome everyone!");
	    String program = "ls";
        ArrayList options = new ArrayList();

        String fileName = "/home/gabrysia/listaaa.txt";
        String directory = "/home/gabrysia/";

        Runnable FileListGenerator = new FileListGenerator(program, options, directory, fileName);
        Thread generateFile = new Thread(FileListGenerator);
        generateFile.start();
    }
}
