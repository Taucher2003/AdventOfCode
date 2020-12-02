package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day1 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH + "input1.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        List<Integer> input = new ArrayList<>();
        for(String entry : content.split(Pattern.quote("\r\n"))){
            System.out.println(entry);
            input.add(Integer.parseInt(entry));
        }
        //Task 1
        for(int i : input){
            for(int j : input){
                if (i != j) {
                    if (i + j == 2020) {
                        System.out.println(i * j);
                    }
                }
            }
        }
        System.out.println("---");
        //Task 2
        for(int i : input){
            for(int j : input){
                for(int k : input) {
                    if (i != j && i != k) {
                        if (i + j + k == 2020) {
                            System.out.println(i * j * k);
                        }
                    }
                }
            }
        }
        System.out.println(input.toString());
    }
}
