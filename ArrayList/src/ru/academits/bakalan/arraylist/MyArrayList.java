package ru.academits.bakalan.arraylist;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] items;
    private int size = 0;
    private int modCount = 0;

    public MyArrayList() {
        //noinspection MoveFieldAssignmentToInitializer
        items = (E[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            //noinspection MoveFieldAssignmentToInitializer
            items = (E[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void trimToSize() {
        modCount++;
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > items.length) {
            modCount++;
            items = Arrays.copyOf(items, minCapacity);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        modCount++;
        if (minCapacity > items.length) {
            items = Arrays.copyOf(items, minCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    private class MyArrayListIterator implements Iterator<E> {
        //TODO: добавить исключения в next.
        /*
        1. next должен кидать исключение
        NoSuchElementException, если коллекция кончилась
        2. next должен кидать исключение
        ConcurrentModificationException, если в коллекции
        добавились/удалились элементы за время обхода
         */
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return (currentIndex + 1 < size);
        }

        @Override
        public E next() {
            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Objects.requireNonNull(a);

        if (a.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, size, a.getClass());
        }
        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1); // Increments modCount
        items[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (items[index] == null) {
                    internalRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(items[index])) {
                    internalRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void internalRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(items, index + 1, items, index, numMoved);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNewElements = a.length;
        ensureCapacityInternal(size + numNewElements);  // Increments modCount
        System.arraycopy(a, 0, items, size, numNewElements);
        size += numNewElements;
        return numNewElements != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);

        Object[] a = c.toArray();
        int numNewElements = a.length;
        ensureCapacityInternal(size + numNewElements);  // Increments modCount

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(items, index, items, index + numNewElements, numMoved);

        System.arraycopy(a, 0, items, index, numNewElements);
        size += numNewElements;
        return numNewElements != 0;
    }

    /*@Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return removePart(c, false);
    }

    private boolean removePart(Collection<?> c, boolean toKeep) {
        boolean modified = false;

        for (int i = 0, j = 0; i < size; i++) {
            if (c.contains(items[i]) == toKeep) {
                items[j++] = items[i];
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] items = this.items;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(items[r]) == complement)
                    items[w++] = items[r];
        } finally {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            if (r != size) {
                System.arraycopy(items, r,
                        items, w,
                        size - r);
                w += size - r;
            }
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    items[i] = null;
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    }
     */

    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public E get(int index) {
        rangeCheck(index);

        return items[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        E oldElement = items[index];
        items[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacityInternal(size + 1); // Increments modCount
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = items[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(items, index + 1, items, index, numMoved);

        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (items[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(items[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (items[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(items[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex < toIndex) {
            throw new IndexOutOfBoundsException();
        }


        return null;
    }
}
