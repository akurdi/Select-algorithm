package com.empiricalstudy.selectionproblem.partitioning;

import com.empiricalstudy.selectionproblem.*;

public abstract class ElementWithSelectedRankPartitioningBase implements ElementWithSelectedRank, DataBasedCount, AlgoName {

    protected long dataMoveCount = 0;
    protected long dataCompareCount = 0;

    @Override
    public RunResultsBean findElementAtSelectedRank(int[] array, int userChoice) {
        if (userChoice <= 0 || userChoice > array.length) {
            throw new IndexOutOfBoundsException(userChoice + " is out of range, array size is " + array.length);
        }
        long start = System.currentTimeMillis();
        int dataWithUserChoiceRank = select(array, 0, array.length - 1, userChoice);
        long end = System.currentTimeMillis();
        return new RunResultsBean(getDataMoveCount(), getDataCompareCount(), end - start, algorithmName(), dataWithUserChoiceRank);
    }

    abstract public int getPivot(int[] array, int start, int end);

    protected int select(int[] array, int start, int end, int userChoice) {
        if (start == end)
            return array[start];

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


    public int partition(int[] array, int start, int end) {
        int pivot = getPivot(array, start, end);

        while (start < end) {
            while ((array[end] > pivot && dataCompareCountIncrement()) && (start < end)) {
                end = end - 1;
            }

            if (start != end) {
                dataMoveCountIncrement();
                array[start] = array[end];
                start = start + 1;
            }

            while ((array[start] < pivot && dataCompareCountIncrement()) && (start < end)) {
                start = start + 1;
            }

            if (start != end) {
                dataMoveCountIncrement();
                array[end] = array[start];
                end = end - 1;
            }
        }

        dataMoveCountIncrement();
        array[end] = pivot;
        return end;
    }


    public long getDataMoveCount() {
        return dataMoveCount;
    }

    public long getDataCompareCount() {
        return dataCompareCount;
    }

    protected void dataMoveCountIncrement() {
        dataMoveCount++;
    }

    protected boolean dataCompareCountIncrement() {
        dataCompareCount++;
        return true;
    }
}
