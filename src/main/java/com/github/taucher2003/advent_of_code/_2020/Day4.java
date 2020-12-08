package com.github.taucher2003.advent_of_code._2020;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day4 {

    public static void main(String[] args) throws IOException {
        File file = new File(Data.RESOURCE_PATH_2020 + "input4.txt");
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
        int valid = 0;
        for(String line : inputs){
            if(line.contains("byr:") && line.contains("iyr:") && line.contains("eyr:") && line.contains("hgt:")
                    && line.contains("hcl:") && line.contains("ecl:") && line.contains("pid:")){
                valid++;
            }
        }
        System.out.println(valid);

        //Task 2
        valid = 0;
        for(String line : inputs){
            boolean passValid = line.contains("byr:") && line.contains("iyr:") && line.contains("eyr:") && line.contains("hgt:")
                    && line.contains("hcl:") && line.contains("ecl:") && line.contains("pid:");
            String[] splittedLine = line.trim().split(Pattern.quote(" "));
            try {
                for (String check : splittedLine) {
                    if(!passValid)
                        continue;
                    String[] part = check.split(Pattern.quote(":"));
                    if (part[0].equals("byr")) {
                        int value = Integer.parseInt(part[1]);
                        passValid &= value >= 1920 && value <= 2002;
                    } else if (part[0].equals("iyr")) {
                        int value = Integer.parseInt(part[1]);
                        passValid &= value >= 2010 && value <= 2020;
                    } else if (part[0].equals("eyr")) {
                        int value = Integer.parseInt(part[1]);
                        passValid &= value >= 2020 && value <= 2030;
                    } else if (part[0].equals("hgt")) {
                        int value = Integer.parseInt(part[1].replace("cm", "").replace("in", ""));
                        if (part[1].endsWith("cm"))
                            passValid &= value >= 150 && value <= 193;
                        else if (part[1].endsWith("in"))
                            passValid &= value >= 59 && value <= 76;
                        else
                            passValid = false;
                    }else if(part[0].equals("hcl")){
                        int value = Integer.decode(part[1].replace("#", "0x"));
                        passValid &= value >= 0 && value <= 0xffffff && part[1].length() == 7;
                    }else if(part[0].equals("ecl")){
                        passValid &= part[1].matches("((amb)|(blu)|(brn)|(gry)|(grn)|(hzl)|(oth))");
                    }else if(part[0].equals("pid")){
                        Integer.parseInt(part[1]);
                        passValid &= part[1].length() == 9;
                    }
                }
                if(passValid)
                    valid++;
            }catch(NumberFormatException ignored) {
                passValid = false;
            }
        }
        System.out.println(valid);
    }
}
