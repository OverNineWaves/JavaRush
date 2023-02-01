package com.javarush.task.pro.task15.task1521;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Временное сохранение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        URL getUrl = new URL(line);
        InputStream inputStream = getUrl.openStream();
        byte[] Buffer = inputStream.readAllBytes();
        String getUrlFromBuf = new String(Buffer);

        Path tempFile = Files.createTempFile(null, null);
        Files.write(tempFile, Buffer);
        //System.out.println(getUrlFromBuf);
        //напишите тут ваш код
    }
}