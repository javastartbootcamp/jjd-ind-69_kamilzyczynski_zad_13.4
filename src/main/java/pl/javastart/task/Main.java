package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        // lista powinna być parametryzowana (analogicznie jak java.util.ArrayList czy java.util.LinkedList)
        CustomList<String> customListOfStrings = new CustomList();
        CustomList<Integer> customListOfIntegers = new CustomList();

        customListOfStrings.add("a");
        customListOfStrings.add("b");
        customListOfStrings.add("c");
        System.out.println(customListOfStrings);

        customListOfStrings.add(3, "d");

        System.out.println(customListOfStrings);

    }
}
