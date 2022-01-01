package com.empiricalstudy.selectionproblem.partitioning;

import com.empiricalstudy.selectionproblem.Util;

public class ElementWithSelectedRankFirstAsPivotAlgorithm extends ElementWithSelectedRankPartitioningBase implements Partitionable {

    public int getPivot(int[] array, int start, int end) {
        return array[start];
    }

    @Override
    public String algorithmName() {
        return "First As Pivot Algorithm";
    }
}
