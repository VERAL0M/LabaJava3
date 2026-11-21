package ru.makerov.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Power {
    public static double calculate(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }
}