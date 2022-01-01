package com.empiricalstudy.selectionproblem;

import com.empiricalstudy.selectionproblem.heap.ElementWithSelectedRankMinHeap;
import com.empiricalstudy.selectionproblem.heap.ElementWithSelectedRankMinMaxHeap;
import com.empiricalstudy.selectionproblem.partitioning.*;

import java.util.*;
import java.util.stream.Collectors;

public class SelectionAlgoRunner {

    static private List<ElementWithSelectedRank> algoList = new ArrayList<>();
    static private SelectionAlgoRunner selectionAlgoRunner = new SelectionAlgoRunner();

    public static SelectionAlgoRunner getInstance() {
        return selectionAlgoRunner;
    }

    private SelectionAlgoRunner() {
        algoList.add(new ElementWithSelectedRankRandomizationAlgorithm());
        algoList.add(new ElementWithSelectedRankMedianOfThreeRandomAlgorithm());
        algoList.add(new ElementWithSelectedRankMedianOfThreeAlgorithm());
        algoList.add(new ElementWithSelectedRankMedianOfMediansAlgorithm());
        algoList.add(new ElementWithSelectedRankMinHeap());
        algoList.add(new ElementWithSelectedRankMinMaxHeap());
//        algoList.add(new ElementWithSelectedRankFirstAsPivotAlgorithm());
    }


    public Map<String, List<RunResultsBean>> RunAllAlgos(int[] arr, int rank) {
        return algoList.stream().map(algo -> callFind((arr1, userChoice) ->
                        algo.findElementAtSelectedRank(arr1, userChoice), Util.copyArray(arr), rank)).
                collect(Collectors.groupingBy(runResultsBean -> runResultsBean.getAlgoName()));
    }


    private static RunResultsBean callFind(ElementWithSelectedRank elementWithSelectedRank, int[] list, int rank) {
        return elementWithSelectedRank.findElementAtSelectedRank(list, rank);
    }

}
