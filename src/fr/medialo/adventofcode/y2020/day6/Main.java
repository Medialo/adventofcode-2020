package fr.medialo.adventofcode.y2020.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("resource/day6.txt");
        final String str = Files.readString(path);
        final Pattern pattern = Pattern.compile("(.*\\w)|(^\\s*$)",Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(str);
        final Set<String> letters = new HashSet<>();
        final Map<String, Integer> lettersMap = new HashMap<>();
        int i = 0;
        int j = 0;
        int counter = 0;
        while (matcher.find()){
            final String tempStr = matcher.group(1);
            if(tempStr != null || matcher.hitEnd()){
                counter++;
                Arrays.asList(tempStr.split("")).forEach(s -> {
                    letters.add(s);
                    lettersMap.compute(s,(s1, integer) -> integer == null ? 1 : ++integer);
                });
            }
            if(tempStr == null || matcher.hitEnd()){
                i += letters.size();
                letters.clear();
                final int finalCounter = counter;
                j += lettersMap.entrySet().stream().filter(e -> e.getValue() == finalCounter).count();
                counter = 0;
                lettersMap.clear();
            }
        }
        System.out.println("anyone " + i);
        System.out.println("everyone " + j);
    }
}
