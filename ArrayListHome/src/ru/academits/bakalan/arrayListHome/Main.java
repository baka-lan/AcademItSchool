package ru.academits.bakalan.arrayListHome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFilePath = "./ArrayListHome/text.txt";
        ArrayList<String> fileStrings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(inputFilePath))) {
            while (scanner.hasNextLine()) {
                fileStrings.add(scanner.nextLine());
            }
        }

        System.out.println(fileStrings);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            int n = numbers.get(i);
            if (n % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
        System.out.println(numbers);

        numbers.addAll(Arrays.asList(1, 3, 5, 1));
        System.out.println(numbers);

        ArrayList<Integer> newNumbers = new ArrayList<>();
        for (int n : numbers) {
            if (!newNumbers.contains(n)) {
                newNumbers.add(n);
            }
        }
        System.out.println(newNumbers);
    }
}

/*
1. Прочитать в список все строки из файла
2. Есть список из целых чисел. Удалить из него все четные числа. В
этой задаче новый список создавать нельзя
3. Есть список из целых чисел, в нём некоторые числа могут
повторяться. Надо создать новый список, в котором будут
элементы первого списка в таком же порядке, но без
повторений
Например, был список [1, 5, 2, 1, 3, 5], должен получиться новый
список [1, 5, 2, 3]
 */