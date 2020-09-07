package main.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Utils {
    public static int[] listToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static int[] setToArray(Set<Integer> set) {
        int[] array = new int[set.size()];
        int index = 0;
        for (int i : set) {
            array[index++] = i;
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printSet(Set<Integer> set) {
        int[] array = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            array[index++] = i;
        }
        Arrays.sort(array);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
