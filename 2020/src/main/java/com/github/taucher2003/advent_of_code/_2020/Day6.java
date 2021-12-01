package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Day6 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH_2020 + "input6.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        List<String> inputs = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for(String line : content.split(Pattern.quote("\r\n"))){
            if(!line.equals("")){
                builder.append(line).append(" ");
            }else{
                inputs.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        inputs.add(builder.toString());

        //Task 1
        int allCountedAnswers = 0;
        for(String line : inputs){
            HashMap<Character, Void> countAnswers = new HashMap<>();
            for(char c : line.toCharArray())
                if(c != ' ')
                    countAnswers.put(c, null);
            allCountedAnswers += countAnswers.size();
        }
        System.out.println(allCountedAnswers);

        //Task 2
        allCountedAnswers = 0;
        for(String line : inputs){
            HashMap<Character, Integer> countAnswers = new HashMap<>();
            for(char c : line.toCharArray())
                if(c != ' ')
                    countAnswers.put(c, countAnswers.getOrDefault(c, 0) + 1);
            for(char c : countAnswers.keySet())
                if(countAnswers.containsKey(c) && countAnswers.get(c) == countChar(line, ' '))
                    allCountedAnswers++;
        }
        System.out.println(allCountedAnswers);
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
