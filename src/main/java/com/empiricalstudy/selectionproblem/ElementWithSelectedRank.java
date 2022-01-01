package com.empiricalstudy.selectionproblem;


@FunctionalInterface
public interface ElementWithSelectedRank {
    RunResultsBean findElementAtSelectedRank(int[] arr, int userChoice);
}
