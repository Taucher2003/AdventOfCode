package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day10 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH_2020 + "input10.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        List<Integer> jolts = new ArrayList<>();
        for(String line : content.split(Pattern.quote("\r\n"))){
            jolts.add(Integer.parseInt(line));
        }
        jolts.sort(Integer::compareTo);

        //Task 1
        int differenceOne = 0;
        int differenceThree = 0;
        int lastJolt = 0;
        for(int jolt : jolts){
            if(jolt - lastJolt == 1)
                differenceOne++;
            if(jolt - lastJolt == 3)
                differenceThree++;
            lastJolt = jolt;
        }
        differenceThree++;

        System.out.println(differenceOne * differenceThree);

        //Task 2
        int possibleArrangements = 1;
        while(true){
            HashMap<Integer, Integer> joltPositioned = new HashMap<>();
            int count = 0;
            for(int jolt : jolts){
                joltPositioned.put(count++, jolt);
            }
            jolts = joltPositioned.entrySet().stream().filter(entry -> {
                if(entry.getKey() < 1 || entry.getKey() >= joltPositioned.size()-1){
                    return true;
                }else{
                    return joltPositioned.get(entry.getKey()+1) - joltPositioned.get(entry.getKey()-1) > 2;
                }
            }).map(Map.Entry::getValue).collect(Collectors.toList());
            possibleArrangements++;
            System.out.println(jolts.toString());
            if(jolts.containsAll(joltPositioned.keySet()))
                break;
        }
        System.out.println(possibleArrangements);
    }
}
