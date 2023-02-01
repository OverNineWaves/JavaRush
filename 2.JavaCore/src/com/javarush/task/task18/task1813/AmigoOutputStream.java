package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{

    FileOutputStream hello;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream hello)throws FileNotFoundException{
        super(fileName);
        this.hello = hello;
    }

    @Override
    public void write(int b) throws IOException {
        hello.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        hello.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        hello.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        hello.flush();
        hello.write("JavaRush © All rights reserved.".getBytes());
        hello.close();
    }

    @Override
    public void flush() throws IOException {
        hello.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
