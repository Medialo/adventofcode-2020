package fr.medialo.adventofcode.y2020.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static final int MAX_ROW = 127;
    private static final int MAX_COL = 7;

    public static void main(String[] args) throws IOException {
        int seatID = 0;
        final Path path = Paths.get("resource/day5.txt");
        final List<String> stringList = Files.readAllLines(path);
        final Set<Integer> seatList = new TreeSet<>();
        for (String str:stringList) {
            int tempRowUp = MAX_ROW;
            int tempColUp = MAX_COL;
            int tempRowDown = 0;
            int tempColDown = 0;
            final String[] letters = str.split("");
            System.out.println(str);
            for (String letter:letters) {
                switch (letter){
                    case "F":
                        tempRowUp = (int) (tempRowUp - (Math.ceil((tempRowUp - tempRowDown) / 2.)));
                        break;
                    case "B":
                        tempRowDown = (int) (tempRowDown + (Math.ceil((tempRowUp - tempRowDown) / 2.)));
                        break;
                    case "L":
                        tempColUp = (int) (tempColUp - ( Math.ceil((tempColUp - tempColDown) / 2.)));
                        break;
                    case "R":
                        tempColDown = (int) (tempColDown + (Math.ceil((tempColUp - tempColDown) / 2.)));
                        break;
                }
            }
            final int tempSeatID = ((letters[6].equals("B") ? tempRowUp : tempRowDown)) * 8 + ((letters[9].equals("R") ? tempColUp : tempColDown));
            System.out.println("row " + (letters[6].equals("B") ? tempRowUp : tempRowDown));
            System.out.println("col " + (letters[9].equals("R") ? tempColUp : tempColDown));
            System.out.println("seat id " + tempSeatID);
            seatList.add(tempSeatID);
            if(tempSeatID > seatID)
                seatID = tempSeatID;
        }
        System.out.println(seatID);
        for (int i = 68; i < seatList.size(); i++) {
            if (!seatList.contains(i))
                System.out.println("my number seat :" + i);
        }


    }
}
