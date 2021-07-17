package fr.medialo.adventofcode.y2020.day7;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final String color;
    private final List<String> bagsInBag = new ArrayList<>();

    public Bag(String color) {
        this.color = color;
    }
}
