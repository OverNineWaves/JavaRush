package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor fileDescriptor) throws IOException{
        this.fileWriter = new FileWriter(fileDescriptor);
    }
    public FileConsoleWriter(String str) throws IOException {
        this.fileWriter = new FileWriter(str);
    }
    public FileConsoleWriter(String str, boolean append) throws IOException {
        this.fileWriter = new FileWriter(str, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf, off, len));
    }

    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException{
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off,  (off + len)));
    }

    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }
    public void close() throws IOException{
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
//        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("/home/overninewaves/3.txt");
//        fileConsoleWriter.write("0123456ss", 2, 5);
//        fileConsoleWriter.close();

    }
}
