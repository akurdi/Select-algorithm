package com.empiricalstudy.selectionproblem.heap;

import com.empiricalstudy.selectionproblem.Util;

public class MaxHeap extends BuildHeap {

    public void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest] && dataCompareCountIncrement())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest] && dataCompareCountIncrement())
            largest = r;

        // If largest is not root
        if (largest != i) {
            Util.swap(arr,largest,i);
            dataMoveCountIncrement();

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

}
