package com.empiricalstudy.selectionproblem.partitioning;

import com.empiricalstudy.selectionproblem.Util;

public class ElementWithSelectedRankMedianOfThreeRandomAlgorithm extends ElementWithSelectedRankPartitioningBase implements Partitionable {

    public int getPivot(int[] array, int start, int end) {
        if ((end - start) < 10) {
            return array[start];
        }

        int firstRandom = Util.getRandom(start + 1, end + 1) - 1;
        Util.swap(array, firstRandom, start);
        dataMoveCountIncrement();
        int secondRandom = Util.getRandom(start + 1, end + 1) - 1;
        int lastRandom = Util.getRandom(start + 1, end + 1) - 1;

        if (dataCompareCountIncrement()&& array[start] > array[secondRandom]) {
            if (dataCompareCountIncrement() && array[start] > array[lastRandom]) {
                if (dataCompareCountIncrement() && array[secondRandom] > array[lastRandom]) {
                    Util.swap(array, secondRandom, start);
                    dataMoveCountIncrement();
                } else {
                    Util.swap(array, lastRandom, start);
                    dataMoveCountIncrement();
                }
            }
        } else {
            if (dataCompareCountIncrement() && array[secondRandom] < array[lastRandom]) {
                Util.swap(array, secondRandom, start);
                dataMoveCountIncrement();
            } else {
                if (dataCompareCountIncrement() && array[lastRandom] > array[start]) {
                    Util.swap(array, lastRandom, start);
                    dataMoveCountIncrement();
                }
            }
        }
        return array[start];
    }

    @Override
    public String algorithmName() {
        return "Median Of three Random Algorithm";
    }
}

