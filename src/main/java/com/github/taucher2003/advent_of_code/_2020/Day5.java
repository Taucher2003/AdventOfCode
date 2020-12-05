package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day5 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH_2020 + "input5.txt");
        String content = new String(Files.readAllBytes(file.toPath()));
        //Task 1
        int highestId = 0;
        for(String entry : content.split(Pattern.quote("\r\n"))){
            int id = getRow(entry) * 8 + getPlace(entry);
            if(id > highestId)
                highestId = id;
        }
        System.out.println(highestId);
        //Task 2
        int lowestId = Integer.MAX_VALUE;
        List<Integer> usedSeats = new ArrayList<>();
        for(String entry : content.split(Pattern.quote("\r\n"))){
            int id = getRow(entry) * 8 + getPlace(entry);
            usedSeats.add(id);
            if(id < lowestId)
                lowestId = id;
        }
        for(int id = lowestId; id<highestId; id++){
            if(!usedSeats.contains(id)){
                System.out.println(id);
            }
        }
    }

    public static int getRow(String seat){
        String check = seat.substring(0, 7);
        return Integer.parseInt(check.replace("F", "0").replace("B", "1"), 2);
    }

    public static int getPlace(String seat){
        String check = seat.substring(7);
        return Integer.parseInt(check.replace("L", "0").replace("R", "1"), 2);
    }
}
