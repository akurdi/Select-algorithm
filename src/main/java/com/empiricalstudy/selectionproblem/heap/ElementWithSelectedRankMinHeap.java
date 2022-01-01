package com.empiricalstudy.selectionproblem.heap;

import com.empiricalstudy.selectionproblem.AlgoName;
import com.empiricalstudy.selectionproblem.DataBasedCount;
import com.empiricalstudy.selectionproblem.ElementWithSelectedRank;
import com.empiricalstudy.selectionproblem.RunResultsBean;

public class ElementWithSelectedRankMinHeap implements ElementWithSelectedRank, DataBasedCount, AlgoName {
    private final MinHeap minHeap = new MinHeap();

    @Override
    public RunResultsBean findElementAtSelectedRank(int[] array, int userChoice) {
        if (userChoice <= 0 || userChoice > array.length) {
            throw new IndexOutOfBoundsException(userChoice + " is out of range, array size is " + array.length);
        }
        long start = System.currentTimeMillis();
        minHeap.buildHeap(array);
        int top = 0;
        while (userChoice != 0) {
            top = minHeap.remove(array);
            userChoice--;
        }
        long end = System.currentTimeMillis();
        return new RunResultsBean(getDataMoveCount(), getDataCompareCount(), end - start, algorithmName(), top);
    }

    @Override
    public String algorithmName() {
        return "min Heap based Algorithm";
    }

    @Override
    public long getDataMoveCount() {
        return minHeap.getDataMoveCount();
    }

    @Override
    public long getDataCompareCount() {
        return minHeap.getDataCompareCount();
    }
}
