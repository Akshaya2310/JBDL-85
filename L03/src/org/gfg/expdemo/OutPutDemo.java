package org.gfg.expdemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutPutDemo {

    public static void main(String[] args) {

        //readFromFile();
        System.out.println(readFromFileReturnValue());
        System.out.println("Done");
    }

    private static void readFromFile()  {
        FileReader fileReader1 = null;
        try {
            fileReader1 = new FileReader("/tmp/test03.txt");
            int a = fileReader1.read();
        } catch (FileNotFoundException e) {
            System.out.println("Getting FileNotFoundException");
        } catch (IOException e) {
            System.out.println("Getting IOException");
        }
        finally {
            System.out.println("Executing finally block.");
        }

    }


    private static int readFromFileReturnValue()  {
        FileReader fileReader1 = null;
        int a =0;
        try {
            fileReader1 = new FileReader("/tmp/test03.txt");
            try {
                a = fileReader1.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //
             //
             //

            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Getting FileNotFoundException :");
        }
        finally {
            System.out.println("Executing finally block.");
            return 10;
        }
        //return 1;
    }


    public void methodThrowsRuntimeException() {

        System.out.println("methodThrowsRuntimeException");
        throw new RuntimeException();
    }
}
