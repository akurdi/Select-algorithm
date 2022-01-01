package com.empiricalstudy.selectionproblem.partitioning;

import com.empiricalstudy.selectionproblem.Util;

public class ElementWithSelectedRankMedianOfThreeAlgorithm extends ElementWithSelectedRankPartitioningBase implements Partitionable {

    public int getPivot(int[] array, int start, int end) {
        if ((end - start) < 3) {
            return array[start];
        }
        int middleIndex = ((end + start) / 2);

        if (dataCompareCountIncrement() && array[start] > array[middleIndex]) {
            if (dataCompareCountIncrement() && array[start] > array[end]) {
                if (dataCompareCountIncrement() && array[middleIndex] > array[end]) {
                    Util.swap(array, middleIndex, start);
                    dataMoveCountIncrement();
                } else {
                    Util.swap(array, end, start);
                    dataMoveCountIncrement();
                }
            }
        } else {
            if (dataCompareCountIncrement() && array[middleIndex] < array[end]) {
                dataMoveCountIncrement();
                Util.swap(array, middleIndex, start);
            } else {
                if (dataCompareCountIncrement() && array[end] > array[start]) {
                    dataMoveCountIncrement();
                    Util.swap(array, end, start);
                }
            }
        }
        return array[start];
    }

    @Override
    public String algorithmName() {
        return "Median Of three Algorithm";
    }
}
