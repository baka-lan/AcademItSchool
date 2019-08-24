package ru.academits.bakalan.list;

public class List<T> {
    private ListItem<T> head;
    private int count;

    public List(T data) {
        head = new ListItem<>(data);
        count = 1;
    }

    public List(List<T> list) {
        if (list == null) {
            throw new NullPointerException("Переданный список = null");
        }

        if (list.head == null) {
            throw new NullPointerException("Переданный список пуст");
        }

        head = new ListItem<>(list.getHead());

        ListItem<T> previous = list.head;
        ListItem<T> newPrevious = head;
        count = list.count;

        while (previous.getNext() != null) {
            ListItem<T> current = previous.getNext();
            ListItem<T> copyCurrent = new ListItem<>(current.getData());
            newPrevious.setNext(copyCurrent);

            previous = current;
            newPrevious = copyCurrent;
        }
    }

    public int getCount() {
        return count;
    }

    public T getHead() {
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }

        return head.getData();
    }

    public T deleteHead() {
        if (head == null) {
            throw new NullPointerException("Список уже пуст");
        }

        T value = head.getData();
        head = head.getNext();
        count--;
        return value;
    }

    public void addNewHead(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("В списке нет элемента с переданным индексом");
        }
    }

    private ListItem<T> listIterator(int index) {
        indexCheck(index);

        ListItem<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private ListItem<T> uncheckableListIterator(int index) {
        ListItem<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public T get(int index) {
        return listIterator(index).getData();
    }

    public T set(int index, T data) {
        ListItem<T> current = listIterator(index);

        T oldValue = current.getData();
        current.setData(data);

        return oldValue;
    }

    public T delete(int index) {
        indexCheck(index);

        if (index == 0) {
            this.deleteHead();
        }

        ListItem<T> previous = uncheckableListIterator(index - 1);
        ListItem<T> current = previous.getNext();

        previous.setNext(current.getNext());
        count--;

        return current.getData();
    }

    public void add(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Переданный индекс меньше нуля, либо больше количества элементов списка");
        }

        if (index == 0) {
            this.addNewHead(data);
            return;
        }

        ListItem<T> previous = uncheckableListIterator(index - 1);

        previous.setNext(new ListItem<>(data, previous.getNext()));
        count++;
    }

    private boolean deleteNullDataElement() {
        if (head == null) {
            throw new NullPointerException("Список уже пуст");
        }

        if (head.getData() == null) {
            head = head.getNext();
            count--;
            return true;
        }

        ListItem<T> previous = head;
        for (ListItem<T> current = head.getNext(); current != null; previous = current, current = current.getNext()) {
            if (current.getData() == null) {
                previous.setNext(current.getNext());
                count--;
                return true;
            }
        }
        return false;
    }

    public boolean delete(T data) {
        if (data == null) {
            return deleteNullDataElement();
        }

        if (head.getData().equals(data)) {
            head = head.getNext();
            count--;
            return true;
        }

        ListItem<T> previous = head;
        for (ListItem<T> current = head.getNext(); current != null; previous = current, current = current.getNext()) {
            if (current.getData().equals(data)) {
                previous.setNext(current.getNext());
                count--;
                return true;
            }
        }

        return false;
    }

    public void reverse() {
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }

        if (head.getNext() == null) {
            return;
        }

        ListItem<T> previous = head.getNext();

        head.setNext(null);

        ListItem<T> current = previous.getNext();
        previous.setNext(head);

        while (current != null) {
            ListItem<T> next = current.getNext();

            current.setNext(previous);
            if (next == null) {
                head = current;
            }

            previous = current;
            current = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (ListItem<T> current = head; current != null; current = current.getNext()) {
            sb.append(current);
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

· копирование списка - done
 */