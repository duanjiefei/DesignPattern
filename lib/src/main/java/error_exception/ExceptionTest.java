package error_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;
import  java.lang.System;

public class ExceptionTest {
    public static void main(String[] args){
        try {
            Thread.sleep(5000);
            System.out.println(" have a tea ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readPreference(String file){
        file = Objects.requireNonNull(file);
        try {
            InputStream is  = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

