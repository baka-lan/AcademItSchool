package ru.academits.bakalan.list.Main;

import ru.academits.bakalan.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new List<>(3);

        numbers.addNewHead(2);
        numbers.addNewHead(1);
        numbers.addNewHead(0);
        System.out.println("numbers: " + numbers);
        System.out.println("numbers.count: " + numbers.getCount());

        System.out.println();
        numbers.reverse();
        System.out.println("reverse numbers: " + numbers);

        System.out.println();
        List<Integer> newNumbers = new List<>(numbers);
        System.out.println("newNumbers: " + newNumbers);

        System.out.println();
        System.out.println("Set 3 as value of 3d element of numbers. Old value: " + numbers.set(2, 3));
        System.out.println("Numbers now: " + numbers);
        System.out.println("3d element of numbers now: " + numbers.get(2));
        System.out.println("3d element of newNumbers does not change. The value: " + newNumbers.get(2));

        System.out.println();
        System.out.println("Head element of number was deleted. Old head value: " + numbers.deleteHead());
        System.out.println("Head element of newNumbers does not change. The value: " + newNumbers.getHead());
        System.out.println("Numbers now: " + numbers + " numbers.count: " + numbers.getCount());
        System.out.println("NewNumbers does not change: " + newNumbers + " newNumbers.count: " + newNumbers.getCount());

        System.out.println();
        System.out.println("3d element of numbers was deleted. The value: " + numbers.delete(2));
        System.out.println("Numbers now: " + numbers);
        System.out.println("numbers.count: " + numbers.getCount());

        System.out.println();
        numbers.add(2, 4);
        System.out.println("New 3d element in numbers: 4");
        numbers.add(1, 2);
        System.out.println("New 2d element in numbers: 2");
        System.out.println("Set 0 as value of 1st element of numbers. Old value: " + numbers.set(0, 0));
        System.out.println("Numbers now: " + numbers);
        System.out.println("numbers.count: " + numbers.getCount());

        System.out.println();
        System.out.println("Delete element has value 0: " + numbers.delete((Integer) 0));
        System.out.println("Delete element has value 4: " + numbers.delete((Integer) 4));
        System.out.println("Numbers now: " + numbers);
        System.out.println("numbers.count: " + numbers.getCount());
    }
}
