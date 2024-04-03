package service;

import exception.InvalidIndexException;
import exception.NullItemException;
import exception.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] storage;
    private int size;

    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public void add(String item) {
        validateSize();
        validateItem(item);

        storage[size++] = item;

    }

    @Override
    public void add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            storage[size++] = item;
            return;
        }

        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
    }

    @Override
    public void set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
    }

    @Override
    public void remove(String item) {
        validateItem(item);

        int index = indexOf(item);

        remove(index);
    }

    @Override
    public void remove(int index) {
        validateIndex(index);

        String item = storage[index];

        if (index != size) {
            System.arraycopy(storage,index+1,storage,index, size - index);
        }

        size--;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = storage[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0 ; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
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
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }
}