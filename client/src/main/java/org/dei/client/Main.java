package org.dei.client;

import org.algo.sort.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("Select Your Sorting Algo for \n 1 : Bubble Sort \n 2 : Selection Sort");
        Scanner sc = new Scanner(System.in);
        int button = sc.nextInt();

        switch (button) {
            case 1 -> {
                System.out.println("Bubble Sort");
                BubbleSort bs = new BubbleSort();
                
                // replace your file name and location
                
                bs.sort("C:\\Users\\deepa\\IdeaProjects\\dsaljava-Deepanshu\\client\\src\\main\\java\\org\\dei\\client\\inputFile.txt",
                        "C:\\Users\\deepa\\IdeaProjects\\dsaljava-Deepanshu\\client\\src\\main\\java\\org\\dei\\client\\outputFile_BubbleSort.txt");
            }
            case 2 -> {
                System.out.println("Selection Sort");
                SelectionSort ss = new SelectionSort();
                ss.sort("C:\\Users\\deepa\\IdeaProjects\\dsaljava-Deepanshu\\client\\src\\main\\java\\org\\dei\\client\\inputFile.txt",
                        "C:\\Users\\deepa\\IdeaProjects\\dsaljava-Deepanshu\\client\\src\\main\\java\\org\\dei\\client\\outputFileSelectionSort.txt");
            }
            default -> System.out.println("Invalid");
        }





        System.out.println("Hello world!");
    }
}
