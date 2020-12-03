package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

public class Day2 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH + "_2020/input2.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        //Task 1
        int validPassword = 0;
        for(String entry : content.split(Pattern.quote("\r\n"))){
            String[] split = entry.split(Pattern.quote(": "));
            String[] requirements = split[0].split(Pattern.quote(" "));
            String[] counts = requirements[0].split(Pattern.quote("-"));
            int min = Integer.parseInt(counts[0]);
            int max = Integer.parseInt(counts[1]);
            int count = countChar(split[1], requirements[1].toCharArray()[0]);
            if(count <= max && count >= min){
                validPassword++;
            }
        }
        System.out.println(validPassword);
        System.out.println("---");
        //Task 2
        validPassword = 0;
        for(String entry : content.split(Pattern.quote("\r\n"))){
            String[] split = entry.split(Pattern.quote(": "));
            String[] requirements = split[0].split(Pattern.quote(" "));
            String[] counts = requirements[0].split(Pattern.quote("-"));
            int first = Integer.parseInt(counts[0]);
            int second = Integer.parseInt(counts[1]);
            char search = requirements[1].toCharArray()[0];
            boolean isFirst = split[1].charAt(first-1) == search;
            boolean isSecond = split[1].charAt(second-1) == search;
            if(isFirst != isSecond){
                validPassword++;
            }
        }
        System.out.println(validPassword);
    }

    public static int countChar(CharSequence sequence, char c) {
        int count = 0;
        for(int i = 0; i<sequence.length(); i++) {
            if(sequence.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
