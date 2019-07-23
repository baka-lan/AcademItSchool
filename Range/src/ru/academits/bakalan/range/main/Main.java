package ru.academits.bakalan.range.main;

import ru.academits.bakalan.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range someRange = new Range(5, 10);

        System.out.println("Первый интервал: " + someRange.toString());

        Range anotherRange = new Range(0, 0);
        System.out.println("Введите второй интервал:");
        System.out.print("Левая точка: ");
        anotherRange.setFrom(scanner.nextDouble());
        System.out.print("Правая точка: ");
        anotherRange.setTo(scanner.nextDouble());

        System.out.println("Второй интервал: " + anotherRange.toString());

        System.out.println("Пересечение:");
        if (someRange.getIntersection(anotherRange) != null) {
            System.out.println(someRange.getIntersection(anotherRange).toString());
        } else {
            System.out.println("null");
        }

        System.out.println("Объединение:");
        System.out.println(Arrays.toString(someRange.getUnion(anotherRange)));

        System.out.println("Разница:");
        System.out.println(Arrays.toString(someRange.getDifference(anotherRange)));
    }
}
