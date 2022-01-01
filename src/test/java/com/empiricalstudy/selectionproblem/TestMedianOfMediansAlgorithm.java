package com.empiricalstudy.selectionproblem;

import com.empiricalstudy.selectionproblem.partitioning.ElementWithSelectedRankMedianOfMediansAlgorithm;
import com.empiricalstudy.selectionproblem.partitioning.ElementWithSelectedRankMedianOfThreeAlgorithm;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestMedianOfMediansAlgorithm implements SelectionAlgorithmTestTemplate {

    public static ElementWithSelectedRank elementWithSelectedRank = new ElementWithSelectedRankMedianOfMediansAlgorithm();

    @Test
    @Override
    public void testSortedData() {
        int[] sortedList = Util.getSortedList(100866);
        int rank = 5;

        Util.print(sortedList);

        int elementAtSelectedRank = elementWithSelectedRank.findElementAtSelectedRank(Util.copyArray(sortedList), rank).getElementAtSelectedRank();;

        int[] copySorted = Util.copyArray(sortedList);
        Arrays.sort(copySorted);

        Assert.assertEquals(copySorted[rank - 1], elementAtSelectedRank);
        System.out.println(" element At (" + rank + ") Rank for sorted list is : " + elementAtSelectedRank);

    }

    @Test
    @Override
    public void testSimiSortedData() {
        int[] simiSortedList = Util.getSimiSortedList( 604);
        int rank = 80;

        Util.print(simiSortedList);

        int elementAtSelectedRank = elementWithSelectedRank.findElementAtSelectedRank(Util.copyArray(simiSortedList), rank).getElementAtSelectedRank();;

        int[] copySorted = Util.copyArray(simiSortedList);
        Arrays.sort(copySorted);

        Assert.assertEquals(copySorted[rank - 1], elementAtSelectedRank);
        System.out.println(" element At (" + rank + ") Rank for simi sorted list is : " + elementAtSelectedRank);
    }

    @Test
    @Override
    public void testRandomData() {
        int[] randomSortedList = Util.getRandomList( 27);
        int rank = 27;

        Util.print(randomSortedList);

        int elementAtSelectedRank = elementWithSelectedRank.findElementAtSelectedRank(Util.copyArray(randomSortedList), rank).getElementAtSelectedRank();;

        int[] copySorted = Util.copyArray(randomSortedList);
        Arrays.sort(copySorted);

        Assert.assertEquals(copySorted[rank - 1], elementAtSelectedRank);
        System.out.println(" element At (" + rank + ") Rank for random list is : " + elementAtSelectedRank);


        int[] randomList2 = Util.getRandomList(1000);
        int rank2 = 1;

        int elementAtSelectedRank2 = elementWithSelectedRank.findElementAtSelectedRank(Util.copyArray(randomList2), rank2).getElementAtSelectedRank();;

        int[] copySorted2 = Util.copyArray(randomList2);
        Arrays.sort(copySorted2);

        Assert.assertEquals(copySorted2[rank2 - 1], elementAtSelectedRank2);
        System.out.println(" element At (" + rank2 + ") Rank for random list is : " + elementAtSelectedRank2);
    }

    @Test
    @Override
    public void testReversedData() {
        int[] simiSortedList = Util.getSortedReversedList(223);
        int rank = 1;

        Util.print(simiSortedList);

        int elementAtSelectedRank = elementWithSelectedRank.findElementAtSelectedRank(Util.copyArray(simiSortedList), rank).getElementAtSelectedRank();;

        int[] copySorted = Util.copyArray(simiSortedList);
        Arrays.sort(copySorted);

        Assert.assertEquals(copySorted[rank - 1], elementAtSelectedRank);
        System.out.println(" element At (" + rank + ") Rank for reversed list is : " + elementAtSelectedRank);
    }
}
