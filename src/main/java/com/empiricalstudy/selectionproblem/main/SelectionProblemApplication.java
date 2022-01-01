package com.empiricalstudy.selectionproblem.main;


import com.empiricalstudy.selectionproblem.RunResultsBean;
import com.empiricalstudy.selectionproblem.SelectionAlgoRunner;
import com.empiricalstudy.selectionproblem.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectionProblemApplication {

    public static final int SIZE = 100_000_000;
    public static final int MIN = 1;
    public static final int NUMBER_OF_RUNS = 3;

    public static void main(String[] args) {
        randomDataTest();
        orderDataTest();
        simiSortedDataTest();
        sortedReversedDataTest();
    }

    private static void randomDataTest() {
        Map<String, List<RunResultsBean>> resultsBean = new HashMap<>();
        int[] array = Util.getRandomList(SIZE);
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            System.out.println("random data run#" + i);
            runAndCollectData(resultsBean, array);
        }

        System.out.println("Random data");
        printFinalResults(resultsBean);
    }

    private static void orderDataTest() {
        Map<String, List<RunResultsBean>> resultsBean = new HashMap<>();
        int[] array = Util.getSortedList(SIZE);
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            System.out.println("sorted data run#" + i);
            runAndCollectData(resultsBean, array);
        }

        System.out.println("sorted data");
        printFinalResults(resultsBean);
    }

    private static void sortedReversedDataTest() {
        Map<String, List<RunResultsBean>> resultsBean = new HashMap<>();
        int[] array = Util.getSortedReversedList(SIZE);
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            System.out.println("revers sorted data run#" + i);
            runAndCollectData(resultsBean, array);
        }

        System.out.println("revers sorted data");
        printFinalResults(resultsBean);
    }

    private static void simiSortedDataTest() {
        Map<String, List<RunResultsBean>> resultsBean = new HashMap<>();
        int[] array = Util.getSimiSortedList(SIZE);
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            System.out.println("simi sorted data run# " + i);
            runAndCollectData(resultsBean, array);
        }
        System.out.println("simi sorted data");
        printFinalResults(resultsBean);
    }

    private static void runAndCollectData(Map<String, List<RunResultsBean>> resultsBean, int[] array) {
        int lowRank = Util.getRandom(MIN, SIZE );
        Map<String, List<RunResultsBean>> stringListMap = SelectionAlgoRunner.getInstance().RunAllAlgos(array, lowRank);
        collectData(resultsBean, stringListMap);
        System.out.println("looking for this rank : " + lowRank);
    }

    private static void collectData(Map<String, List<RunResultsBean>> resultsBean, Map<String, List<RunResultsBean>> stringListMap) {
        for (Map.Entry<String, List<RunResultsBean>> stringListEntry : stringListMap.entrySet()) {
            if (!resultsBean.containsKey(stringListEntry.getKey())) {
                List<RunResultsBean> runResultsBeans = new ArrayList<>();
                resultsBean.put(stringListEntry.getKey(), runResultsBeans);
            }
            List<RunResultsBean> runResultsBeans = resultsBean.get(stringListEntry.getKey());
            runResultsBeans.addAll(stringListEntry.getValue());
        }
    }

    private static void printFinalResults(Map<String, List<RunResultsBean>> resultsBean) {
        System.out.println("____________________________________________________________________________________________________");
        for (Map.Entry<String, List<RunResultsBean>> stringListEntry : resultsBean.entrySet()) {
            long dcSum = 0;
            long dmSum = 0;
            long msSum = 0;
            System.out.print("| " + stringListEntry.getKey() + " |");
            System.out.print("| " + stringListEntry.getValue().size() + " |");
            for (RunResultsBean runResultsBean : stringListEntry.getValue()) {
                dmSum += runResultsBean.getDataMoveCount();
                dcSum += runResultsBean.getDataCompereCount();
                msSum += runResultsBean.getMsTime();
            }
            System.out.print("| " + dmSum + " |");
            System.out.print("| " + dcSum + " |");
            System.out.print("| " + msSum + " |");

            System.out.print("| " + (dmSum / stringListEntry.getValue().size()) + " |");
            System.out.print("| " + (dcSum / stringListEntry.getValue().size()) + " |");
            System.out.print("| " + (msSum / stringListEntry.getValue().size()) + " |");
            System.out.println();
        }
        System.out.println("____________________________________________________________________________________________________");
    }

}
