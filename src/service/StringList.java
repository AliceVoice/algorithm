package service;

public interface StringList {
    void add(String item);

    void add(int index, String item);

    void set(int index, String item);

    void remove(String item);

    void remove(int index);

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String get(int index);

    boolean equals(StringList otherList);

    int size();

    boolean isEmpty();

    void clear();

    String[] toArray();
}