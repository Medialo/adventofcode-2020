package fr.medialo.adventofcode.y2020.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("resource/day4.txt");
        final String str = Files.readString(path);
        final Pattern pattern = Pattern.compile("((.{3}):(\\S*)|(?<nl>^\\s*$))",Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(str);
        final List<String> lists = new ArrayList<>(8);
        int i = 0;
        while(matcher.find()) {
            final String tempMatch = matcher.group(2);
            if(tempMatch != null || matcher.hitEnd()){
                lists.add(tempMatch);
            }
            if(tempMatch == null || matcher.hitEnd()){
                final int size = lists.size();
                if(size == 8 || size == 7 && !lists.contains("cid")) {
                    i++;

                }
                lists.clear();
            }

        }
        System.out.println(i);
    }
}
