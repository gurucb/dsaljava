package org.algo.sort;

public class SortAdapter {
    public static Sort getSortObject(String sortType)
    {
        Sort sort = new MergeSort();
        return sort;
    }
}
