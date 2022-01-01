package com.empiricalstudy.selectionproblem.heap;

import com.empiricalstudy.selectionproblem.AlgoName;
import com.empiricalstudy.selectionproblem.DataBasedCount;
import com.empiricalstudy.selectionproblem.ElementWithSelectedRank;
import com.empiricalstudy.selectionproblem.RunResultsBean;

public class ElementWithSelectedRankMinMaxHeap implements ElementWithSelectedRank, DataBasedCount, AlgoName {

    private final MinHeap minHeap = new MinHeap();
    private final MaxHeap maxHeap = new MaxHeap();

    @Override
    public RunResultsBean findElementAtSelectedRank(int[] array, int userChoice) {
        if (userChoice <= 0 || userChoice > array.length) {
            throw new IndexOutOfBoundsException(userChoice + " is out of range, array size is " + array.length);
        }
        long start = System.currentTimeMillis();
        int mid = array.length / 2;
        int top = 0;

        if (userChoice <= mid) {
            minHeap.buildHeap(array);

            while (userChoice != 0) {
                top = minHeap.remove(array);
                userChoice--;
            }
        } else {
            userChoice = array.length - userChoice + 1;

            maxHeap.buildHeap(array);

            while (userChoice != 0) {
                top = maxHeap.remove(array);
                userChoice--;
            }

        }
        long end = System.currentTimeMillis();
        return new RunResultsBean(getDataMoveCount(), getDataCompareCount(), end - start, algorithmName(), top);
    }

    @Override
    public String algorithmName() {
        return "min and max Heap Algorithm";
    }

    @Override
    public long getDataMoveCount() {
        return minHeap.getDataMoveCount() + maxHeap.getDataMoveCount();
    }

    @Override
    public long getDataCompareCount() {
        return minHeap.getDataCompareCount() + maxHeap.getDataCompareCount();
    }
}
