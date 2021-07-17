package fr.medialo.adventofcode.y2020.day2;

public class Password {
    final int min;
    final int max;
    final char letter;
    final String password;

    public Password(int min, int max, char letter, String password) {
        this.min = min;
        this.max = max;
        this.letter = letter;
        this.password = password;
    }

    public static boolean isValid(int min, int max, char letter, String password) {
        int i = 0;
        for (char c : password.toCharArray()) {
            if (letter == c) {
                i++;
            }
        }
        return i <= max && i >= min;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid() {
        return isValid(this.min, this.max, this.letter, this.password);
    }
}
