package ru.academits.bakalan.list;

public class List<T> {
    private ListItem<T> head;
    private int count;

    public List(T data) {
        head = new ListItem<>(data);
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public T getHead() {
        return head.getData();
    }

    public T deleteHead() {
        T value = head.getData();
        head = head.getNext();
        count--;
        return value;
    }

    public void addNewHead(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public T get(int index) {
        if (index >= count) {
            throw new IndexOutOfBoundsException();
        }

        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        return p.getData();
    }

    public T set(int index, T data) {
        if (index >= count) {
            throw new IndexOutOfBoundsException();
        }

        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }
        T oldValue = p.getData();
        p.setData(data);

        return oldValue;
    }

    public T delete(int index) {
        if (index == 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        ListItem<T> p = head.getNext();
        ListItem<T> prev = head;
        for (int i = 1; i < index; i++) {
            prev = p;
            p = p.getNext();
        }
        prev.setNext(p.getNext());
        count--;

        return p.getData();
    }

    public void add(int index, T data) {
        if (index == 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        ListItem<T> p = head.getNext();
        ListItem<T> prev = head;
        for (int i = 1; i < index; i++) {
            prev = p;
            p = p.getNext();
        }
        prev.setNext(new ListItem<>(data, p));
        count++;
    }
}

/*
· получение размера списка - done

· получение значение первого элемента - done

· получение/изменение значения по указанному индексу. - done
Изменение значения по индексу пусть выдает старое значение.

· удаление элемента по индексу, пусть выдает значение элемента - done

· вставка элемента в начало - done

· вставка элемента по индексу - done

· удаление узла по значению, пусть выдает true, если элемент был удален

· удаление первого элемента, пусть выдает значение элемента - done

· разворот списка за линейное время

· копирование списка
 */