package ru.academits.bakalan.list;

public class List<T> {
    private ListItem<T> head;
    private int count;

    public List(T data) {
        head = new ListItem<>(data);
        count = 1;
    }

    public List(List<T> list) {
        head = list.head;
        count = list.count;
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

    public boolean delete(T data) {
        if (head.getData().equals(data)) {
            head = head.getNext();
            count--;
            return true;
        }
        ListItem<T> prev = head;
        for (ListItem<T> p = head.getNext(); p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                prev.setNext(p.getNext());
                count--;
                return true;
            }
        }
        return false;
    }

    public void reverse() {
        if (head.getNext() != null) {
            ListItem<T> prev = head.getNext();

            head.setNext(null);

            ListItem<T> p = prev.getNext();
            prev.setNext(head);

            while (p != null) {
                ListItem<T> next = p.getNext();

                p.setNext(prev);
                if (next == null) {
                    head = p;
                }

                prev = p;
                p = next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            sb.append(p);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");

        return sb.toString();
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

· удаление узла по значению, пусть выдает true, если элемент был удален - done

· удаление первого элемента, пусть выдает значение элемента - done

· разворот списка за линейное время - done

· копирование списка - not done
 */