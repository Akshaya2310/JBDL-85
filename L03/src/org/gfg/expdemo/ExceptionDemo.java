package org.gfg.expdemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("Starting...");
        System.out.println("executing 1");

        System.out.println("Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
//        if(name.length()>5) {
//            System.out.println(name.charAt(5));
//        }
        try{
            System.out.println(name.charAt(5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("executing 2");
        System.out.println("executing 3");
        System.out.println("Exiting...");


            readFromFile();

        try {
            readFromFile2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void readFromFile()  {
        FileReader fileReader1 = null;
        try {
            fileReader1 = new FileReader("/tmp/test03.txt");
            int a = fileReader1.read();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fileReader1 != null){
                try {
                    fileReader1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        try (FileReader fileReader2 = new FileReader("/tmp/test03.txt");){
            int a = fileReader2.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static void readFromFile2() throws IOException {
        FileReader fileReader1 = null;
            fileReader1 = new FileReader("/tmp/test03.txt");
            int a = fileReader1.read();
    }
}

