package org.algo.sort;

import java.util.Scanner;

public class SortAdapter {
    public static void sort() {
        String inputFile = "C:\\Users\\Ashish Singh\\Downloads\\inputFile.txt";
        String outputFile = "E:\\New folder\\internship data\\outputFile";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the sorting algorithm (1 for Bubble Sort, 2 for Insertion Sort, 3 for Selection Sort, 4 for Merge Sort, 5 for Quick Sort):");
        int algorithmChoice = scanner.nextInt();

        Sort sortAlgorithm;
        switch (algorithmChoice) {
            case 1:
                sortAlgorithm = new BubbleSort();
                break;
            case 2:
                sortAlgorithm = new InsertionSort();
                break;
            case 3:
                sortAlgorithm = new SelectionSort();
                break;
            case 4:
                sortAlgorithm = new MergeSort();
                break;
            case 5:
                sortAlgorithm = new QuickSort();
                break;
          
            default:
                System.out.println("Invalid choice. Using Bubble Sort as the default algorithm.");
                sortAlgorithm = new BubbleSort();
        }

        Thread sortingThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sortAlgorithm.sort(inputFile, outputFile);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println("Sorting completed. Execution time: " + executionTime + " milliseconds.");
        });

        sortingThread.start();
        try {
            sortingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

