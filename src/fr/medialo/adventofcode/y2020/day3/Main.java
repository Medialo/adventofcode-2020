package fr.medialo.adventofcode.y2020.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static final char EMPTY_CASE = '.';
    public static final char TREE = '#';
    public static final int RIGHT = 3;
    public static final int DOWN = 1;
    public static int LINE_LENGTH = -1;
    public static int LIST_SIZE = -1;

    public static void main(String[] args) {
        Path path = Paths.get("resource/day3.txt");
        List<String> strings = new LinkedList<>();
        int result = 0;
        try(BufferedReader bfr = new BufferedReader(new FileReader(path.toFile()))){
            String str;
            while ((str = bfr.readLine()) != null){
                strings.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LINE_LENGTH = strings.get(1).length();
        LIST_SIZE = strings.size();
        char[][] chars = new char[LIST_SIZE][LINE_LENGTH];
        for (int i = 0; i < LIST_SIZE; i++) {
            chars[i] = strings.get(i).toCharArray();
        }
        int x= 0,y = 0;
        while(true){
            x+=DOWN;
            if(x >= LIST_SIZE)
                break;
            y = (y + RIGHT)%LINE_LENGTH;
            System.out.println(y);
            if(chars[x][y] == TREE)
                result++;
        }
        System.out.println(result);
    }
}
