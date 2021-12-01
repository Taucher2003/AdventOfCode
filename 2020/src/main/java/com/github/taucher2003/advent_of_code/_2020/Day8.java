package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day8 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH_2020 + "input8.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        HashMap<Integer, String> lines = new HashMap<>();
        int lineCount = 0;
        for(String line : content.split(Pattern.quote("\r\n"))){
            lines.put(lineCount++, line);
        }

        //Task 1
        List<Integer> executedLines = new ArrayList<>();
        int nextLine = 0;
        int acc = 0;
        while(!executedLines.contains(nextLine) && executedLines.size() < lines.size()){
            String line = lines.get(nextLine);
            executedLines.add(nextLine);
            if(line.startsWith("acc ")){
                acc += Integer.parseInt(line.replace("acc ", ""));
                nextLine++;
            }else if(line.startsWith("jmp ")){
                nextLine += Integer.parseInt(line.replace("jmp ", ""));
            }else{
                nextLine++;
            }
        }
        System.out.println(acc);

        //Task 2
        List<Integer> jmp = lines.keySet().stream().filter(s -> lines.get(s).startsWith("jmp ")).collect(Collectors.toList());
        for(int index : jmp){
            acc = 0;
            nextLine = 0;
            executedLines = new ArrayList<>();
            while(!executedLines.contains(nextLine) && nextLine < lines.size()){
                String line = lines.get(nextLine);
                executedLines.add(nextLine);
                if(index == nextLine){
                    nextLine++;
                }else if(line.startsWith("acc ")){
                    acc += Integer.parseInt(line.replace("acc ", ""));
                    nextLine++;
                }else if(line.startsWith("jmp ")){
                    nextLine += Integer.parseInt(line.replace("jmp ", ""));
                }else{
                    nextLine++;
                }
                if(nextLine == lines.size())
                    System.out.println(acc);
            }
        }
    }

}
