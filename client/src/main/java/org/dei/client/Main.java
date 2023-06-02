package org.dei.client;

import org.algo.sort.Sort;
import org.algo.sort.SortAdapter;





public class Main {
    public static void main(String[] args) {
        Sort sort = SortAdapter.getSortObject("InsertionSort");
        sort.sort("C:\\Users\\bhara\\IdeaProjects\\dsaljava\\input_File.txt","C:\\Users\\bhara\\IdeaProjects\\dsaljava\\output_File.txt");


    }
}