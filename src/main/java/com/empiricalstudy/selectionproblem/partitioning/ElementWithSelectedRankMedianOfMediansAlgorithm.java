package com.empiricalstudy.selectionproblem.partitioning;

import com.empiricalstudy.selectionproblem.Util;

import java.util.HashMap;

public class ElementWithSelectedRankMedianOfMediansAlgorithm extends ElementWithSelectedRankPartitioningBase implements Partitionable {


    protected int select(int[] array, int start, int end, int userChoice) {
        if (start == end)
            return array[start];

        if (end - start <= 5) {
            insertionSort(array, start, end + 1);
            return array[start + userChoice - 1];
        }

        int mid = partition(array, start, end);
        int k = mid - start + 1;

        if (dataCompareCountIncrement() && k == userChoice) {
            return array[mid];
        } else if (userChoice < k) {
            return select(array, start, mid - 1, userChoice);
        } else {
            return select(array, mid + 1, end, userChoice - k);
        }
    }

    public int getPivot(int[] array, int start, int end) {
        HashMap<Integer, Integer> medianToIndexInOriginalArray = new HashMap<>();
        int n = end - start + 1;

        int i;

        int[] median = new int[Math.floorDiv(n + 4, 5)];

        for (i = 0; i < n / 5; i++) {
            int medianIndex = findMedian(array, start + i * 5, start + i * 5 + 5);
            median[i] = array[medianIndex];
            dataMoveCountIncrement();
            medianToIndexInOriginalArray.put(array[medianIndex], medianIndex);
        }

        // For last group with less than 5 elements
        if (i * 5 < n) {
            int medianIndex = findMedian(array, start + i * 5, start + i * 5 + n % 5);
            median[i] = array[medianIndex];
            dataMoveCountIncrement();
            medianToIndexInOriginalArray.put(array[medianIndex], medianIndex);
            i++;
        }


        int medianOfMedians = (i == 1) ? median[i - 1] :
                findMedianOfMedians(median, 0, i - 1);
        int medianOfMediansIndex = medianToIndexInOriginalArray.get(medianOfMedians);
        Util.swap(array, start, medianOfMediansIndex);
        dataMoveCountIncrement();
        return array[start];
    }

    private int findMedianOfMedians(int[] array, int start, int end) {
        int n = end - start + 1;

        int i;

        // There will be floor((n+4)/5) groups;
        int[] median = new int[Math.floorDiv(n + 4, 5)];

        for (i = 0; i < n / 5; i++) {
            median[i] = array[findMedian(array, start + i * 5, start + i * 5 + 5)];
            dataMoveCountIncrement();
        }

        // For last group with less than 5 elements
        if (i * 5 < n) {
            median[i] = array[findMedian(array, start + i * 5, start + i * 5 + n % 5)];
            dataMoveCountIncrement();
            i++;
        }

        return (i == 1) ? median[i - 1] :
                findMedianOfMedians(median, 0, i - 1);
    }

    private int findMedian(int[] array, int start, int end) {
        if (end - start != 5) {
            insertionSort(array, start, end);
            return (end - start) / 2;
        }
        if (dataCompareCountIncrement() && array[start] < array[start + 1]) {
            Util.swap(array, start, start + 1);
            dataMoveCountIncrement();
        }
        if (dataCompareCountIncrement() && array[start + 2] < array[start + 3]) {
            Util.swap(array, start + 2, start + 3);
            dataMoveCountIncrement();
        }

        if (dataCompareCountIncrement() && array[start] < array[start + 2]) {
            Util.swap(array, start, start + 2);
            Util.swap(array, start + 1, start + 3);
            dataMoveCountIncrement();
            dataMoveCountIncrement();
        }
        // we don't require a[0] any more.

        if (dataCompareCountIncrement() && array[start + 1] < array[start + 4]) {
            Util.swap(array, start + 1, start + 4);
            dataMoveCountIncrement();
        }

        if (dataCompareCountIncrement() && array[start + 1] > array[start + 2]) {
            if (dataCompareCountIncrement() && array[start + 2] > array[start + 4]) {
                return start + 2;
            } else {
                return start + 4;
            }
        } else {
            if (dataCompareCountIncrement() && array[start + 1] > array[start + 3]) {
                return start + 1;
            } else {
                return start + 3;
            }
        }
    }

    private void insertionSort(int[] array, int start, int end) {
        for (int i = start + 1; i < end; ++i) {
            int key = array[i];
            dataMoveCountIncrement();
            int j = i - 1;

            while (j >= start && array[j] > key && dataCompareCountIncrement()) {
                array[j + 1] = array[j];
                dataMoveCountIncrement();
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String algorithmName() {
        return "Median Of Medians Algorithm";
    }
}
