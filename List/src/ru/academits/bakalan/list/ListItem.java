package ru.academits.bakalan.list;

class ListItem<T> {
    private T data;
    private ListItem<T> next;

    ListItem(T data) {
        this.data = data;
    }
    ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }
    ListItem(ListItem<T> p) {
        this.data = p.data;
        this.next = p.next;
    }

    T getData() {
        return data;
    }
    void setData(T data) {
        this.data = data;
    }

    ListItem<T> getNext() {
        return next;
    }

    void setNext(ListItem<T> next){
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
