package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Day3 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH_2020 + "input3.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        //Task 1
        int right = -3;
        int trees = 0;
        for(String entry : content.split("\r\n")) {
            if (entry.length() == 0)
                continue;
            int pos = (right + 3) % entry.length();
            char currentPos = entry.substring(pos, pos+1).toCharArray()[0];
            if(currentPos == '#') {
                trees++;
            }
            right += 3;
        }
        System.out.println(trees + "");
        //Task 2
        int result = 1;
        result *= getTrees(1, 1);
        result *= getTrees(3, 1);
        result *= getTrees(5, 1);
        result *= getTrees(7, 1);
        result *= getTrees(1, 2);
        System.out.println(result + "");
    }

    public static int getTrees(int right, int down) throws IOException {
        int trees = 0;
        File file = new File(Data.RESOURCE_PATH_2020 + "input3.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        int posRight = -right;
        int line = 0;
        for(String entry : content.split("\r\n")) {
            if (entry.length() == 0)
                continue;
            if(line % down == 0) {
                int pos = (posRight + right) % entry.length();
                char currentPos = entry.substring(pos, pos+1).toCharArray()[0];
                if (currentPos == '#') {
                    trees++;
                }
                posRight += right;
            }
            line++;
        }
        return trees;
    }
}
