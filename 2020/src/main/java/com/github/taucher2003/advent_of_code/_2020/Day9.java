package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day9 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH_2020 + "input9.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        HashMap<Integer, Long> lines = new HashMap<>();
        long[] last25 = new long[25];
        int lineNumber = 0;
        for(String line : content.split(Pattern.quote("\r\n"))){
            lines.put(lineNumber++, Long.parseLong(line));
            if(last25[24] != 0)
                continue;
            last25 = rotateArray(last25, Long.parseLong(line));
        }

        //Task 1
        int falseNumber = 0;
        int lineCount = 0;
        for(String line : content.split(Pattern.quote("\r\n"))){
            lineCount++;
            if(lineCount > 25) {
                int thisLine = Integer.parseInt(line);
                if (!isSum(last25, thisLine)) {
                    System.out.println(thisLine);
                    falseNumber = thisLine;
                    break;
                }
                last25 = rotateArray(last25, thisLine);
            }
        }

        //Task 2
        for(int i = 0; i<lines.size(); i++){
            for(int j = i+1; j<lines.size(); j++){
                int finalI = i;
                int finalJ = j;
                List<Long> tryLines = lines.entrySet().stream().filter(entry -> entry.getKey() >= finalI && entry.getKey() < finalJ)
                        .map(Map.Entry::getValue).collect(Collectors.toList());
                if(isArraySum(tryLines.toArray(new Long[0]), falseNumber)){
                    System.out.println(lines.get(finalI) + lines.get(finalJ-1));
                }
            }
        }
    }

    public static long[] rotateArray(long[] input, long insert){
        for(int i = input.length-1; i>0; i--)
            input[i] = input[i-1];
        input[0] = insert;
        return input;
    }

    public static boolean isArraySum(Long[] input, long result){
        int arrayResult = 0;
        for(long i : input)
            arrayResult += i;
//        System.out.println(arrayResult + " | " + result + " | " + (result - arrayResult) + " | " + input.length + " | " + input[0] + " -> " + input[input.length-1]);
        return arrayResult == result;
    }

    public static boolean isSum(long[] input, long result){
        for(long a : input)
            for(long b : input)
                if(a != b)
                    if(a + b == result)
                        return true;
        return false;
    }
}
