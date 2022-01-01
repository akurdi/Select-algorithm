package com.empiricalstudy.selectionproblem;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Util {

    public static void swap(int[] array, int indexI, int indexJ) {
        int temp = array[indexI];
        array[indexI] = array[indexJ];
        array[indexJ] = temp;
    }

    public static int getRandom(int start, int end) {
        Random rand = new Random();
        return rand.nextInt((end - start) + 1) + start;
    }

    public static int[] getSortedList(int size) {
        return IntStream.range(1, size+1).toArray();
    }

    public static int[] getRandomList(int size) {
        return new Random().ints(size, 1, size).toArray();
    }

    public static int[] getSortedReversedList(int size) {
        int[] sortedList = getSortedList(size);
        int[] reversedList = new int[sortedList.length];

        int j = 0;
        for (int i = sortedList.length - 1; i >= 0; i--) {
            reversedList[j] = sortedList[i];
            j++;
        }

        return reversedList;
    }

    public static int[] getSimiSortedList(int size) {
        int randomRange = getRandom(1, 10);

        int[] simiSortedList = new int[size];


        int j = 0;
        for (int i = 0; i < randomRange; i++) {

            int[] sortedList = getSortedList(size / randomRange);

            for (int i1 = 0; i1 < sortedList.length; i1++) {
                if (j >= size) break;
                simiSortedList[j++] = sortedList[i1];
            }
        }

        for (int i = j; i < size; i++) {
            simiSortedList[i] = i;
        }

        return simiSortedList;
    }

    public static int[] copyArray(int array[]) {
        return Arrays.copyOf(array, array.length);
    }

    public static void print(int array[]) {
//        for (int i = 0; i <array.length; i++) {
//            System.out.print(array[i] + " , ");
//        }
//        System.out.println();
    }
}
