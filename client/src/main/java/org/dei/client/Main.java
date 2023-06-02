package org.dei.client;

import org.algo.sort.Sort;
import org.algo.sort.SortAdapter;
public class Main {
    public static void main(String[] args) {
        Sort sort = SortAdapter.getSortObject("ShellSort");
        sort.sort("C:\\Users\\hp\\dsaljava\\input.txt","C:\\Users\\hp\\dsaljava\\output.txt");
    }
}