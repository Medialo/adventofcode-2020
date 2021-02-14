package fr.medialo.adventofcode.y2020.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("resource/day4.txt");
        try(BufferedReader bfr = new BufferedReader(new FileReader(path.toFile()))){
            String str;
            while ((str = bfr.readLine()) != null){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
