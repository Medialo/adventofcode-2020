package fr.medialo.adventofcode.y2020.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        int result = 0;
        Path path = Paths.get("resource/day2.txt");
        try (BufferedReader bfr = new BufferedReader(new FileReader(path.toFile()))) {
            Pattern p = Pattern.compile("([0-9]+)-([0-9]+) (.): (.+)");
            Matcher m;
            String str;
            while ((str = bfr.readLine()) != null) {
                m = p.matcher(str);
                if (m.find())
                    if (Password.isValid(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), m.group(3).charAt(0), m.group(4))) {
                        result++;
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
