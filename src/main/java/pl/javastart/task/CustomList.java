package pl.javastart.task;

import java.util.Arrays;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {
    private T[] list;
    private final int DEFAULT_CAPACITY = 10;

    private int countElements;

    public CustomList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public CustomList(int size) {
        list = (T[]) new Object[size];
    }

    public T get(int index) {
        if (index < countElements && index >= 0) {
            return list[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(T element) {
        countElements++;
        checkSize();
        list[countElements - 1] = element;

    }

    public void add(int index, T element) {
        if (index < list.length && index >= 0) {
            countElements++;
            checkSize();
            if (index == countElements - 1) {
                list[index] = element;
            } else {
                T[] newList = Arrays.copyOf(list, list.length + 1);
                System.arraycopy(list, 0, newList, 0, index);
                newList[index] = element;
                System.arraycopy(list, index, newList, index + 1, countElements - index - 1);
                list = newList;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return countElements;
    }

    public void remove(int index) {
        list[index] = null;
        for (int i = index; i < list.length; i++) {
            if (i == list.length - 1) {
                list[i] = null;
            } else {
                list[i] = list[i + 1];
            }
        }
        countElements--;
    }

    // 1, 3, 4, 5
    // 1, 2, 3, 4, 5

    public void checkSize() {
        if (countElements >= list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
    }

    @Override
    public String toString() {
        String result = "[" + list[0] + ", ";
        for (int i = 1; i < countElements; i++) {
            if (i == countElements - 1) {
                result += list[i] + "]";
            } else {
                result += list[i] + ", ";
            }
        }
        return result;
    }
}
