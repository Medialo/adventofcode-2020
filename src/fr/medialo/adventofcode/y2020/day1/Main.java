package fr.medialo.adventofcode.y2020.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int TARGET = 2020;

    public static void main(String[] args) {
        Path path = Paths.get("resource/day1.txt");
        List<Integer> list = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(path.toFile()))) {
            String str;
            while ((str = bfr.readLine()) != null) {
                list.add(Integer.parseInt(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.sort((o1, o2) -> {
            if (o1.equals(o2)) return 0;
            return o1 > o2 ? 1 : -1;
        });
        int result = 0;
        int localTarget;
//        while (localTarget != TARGET){
        for (int i = 0; i < list.size(); i++) {
            int tempi = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == i) j++;
                localTarget = tempi + list.get(j);
                if (localTarget == TARGET) {
                    result = tempi * list.get(j);
                    break;
                }
            }
            if (result != 0)
                break;
        }
        System.out.println(result);
//        }


    }
}
