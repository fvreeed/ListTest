package org.green;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Создаем списки для эксперимента
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        HashSet<String> hashSet = new HashSet<>();

        // Тестируем и сохраняем всё в список для результатов
        ArrayList<Measuring> listOfResults = new ArrayList<>(
                List.of(addInList(arrayList), addInList(linkedList), addInSet(treeSet), addInSet(hashSet),
                        findInList(arrayList), findInList(linkedList), findInSet(treeSet), findInSet(hashSet),
                        deleteFromList(arrayList), deleteFromList(linkedList), deleteFromSet(treeSet), deleteFromSet(hashSet)));


        // Вывод
        System.out.println("List Name \t   Method Name \t Time");
        for (Measuring listOfResult : listOfResults) {
            output(listOfResult);
        }
    }

    private static void output(Measuring measuring){
        String name = measuring.getListName();
        String methodName = measuring.getMethodName();
        long time = measuring.getTime();
        System.out.printf("%10s\t|\t  %-7s  |  %d\n", name, methodName, time);
    }

    private static Measuring addInList(List<String> list) {
        String listName = list.getClass().getSimpleName();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add("Hello World mr" + i);
        }
        time = System.currentTimeMillis() - time;
        return new Measuring(listName, "add", time);
    }

    private static Measuring addInSet(Set<String> set) {
        String setName = set.getClass().getSimpleName();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            set.add("Hello World mr" + i);
        }
        time = System.currentTimeMillis() - time;
        return new Measuring(setName, "add", time);
    }

    private static Measuring findInList(List<String> list) {
        String listName = list.getClass().getSimpleName();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.get(i);
        }
        time = System.currentTimeMillis() - time;
        return new Measuring(listName, "find", time);
    }

    private static Measuring findInSet(Set<String> set) {
        String setName = set.getClass().getSimpleName();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            set.contains("Hello World mr" + i);
        }
        time = System.currentTimeMillis() - time;
        return new Measuring(setName, "find", time);
    }

    private static Measuring deleteFromList(List<String> list) {
        String listName = list.getClass().getSimpleName();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.remove("Hello World mr" + i);
        }
        time = System.currentTimeMillis() - time;
        return new Measuring(listName, "remove", time);
    }

    private static Measuring deleteFromSet(Set<String> set) {
        String listName = set.getClass().getSimpleName();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            set.remove("Hello World mr" + i);
        }
        time = System.currentTimeMillis() - time;
        return new Measuring(listName, "remove", time);
    }
}