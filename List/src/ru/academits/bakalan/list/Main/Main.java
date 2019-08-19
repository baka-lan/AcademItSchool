package ru.academits.bakalan.list.Main;

import ru.academits.bakalan.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new List<>(3);

        numbers.addNewHead(2);
        numbers.addNewHead(1);
        numbers.addNewHead(0);
        System.out.println(numbers);

        numbers.reverse();
        System.out.println(numbers);

        List<Integer> newNumbers = new List<>(numbers);
        System.out.println(newNumbers);

        numbers.set(2, 3);
        System.out.println(numbers.get(2));
        System.out.println(newNumbers.get(2));

        System.out.println(numbers.deleteHead());
        System.out.println(numbers);
        System.out.println(newNumbers);
    }
}
