package org.algo.sort;

public class SortAdapter {
    public static Sort getSortObject(String sortType) {
        if (sortType == "BubbleSort") {
            Sort sort = new BubbleSort();
            return sort;
        }
        else if (sortType=="SelectionSort")
        {Sort sort=new SelectionSort();
            return sort;
        }
        else if (sortType=="InsertionSort") {
            Sort sort=new InsertionSort();
            return sort;
        }
        else if (sortType=="ShellSort") {
            Sort sort=new ShellSort();
            return sort;

        }
        return null;
    }
}