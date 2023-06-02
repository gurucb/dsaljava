package org.algo.sort;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;
public class Main {

    public static void main(String[] args)  {
        Scanner in= new Scanner(System.in);
        System.out.println("Hello there!");
        System.out.println("Enter your Choice");
        System.out.println("Mergesort");
        System.out.println("Bubblesort");
        System.out.println("Heapsort");
        System.out.println("Selectionsort");
        System.out.println("Quicksort");
        System.out.println("Insertionsort");
        System.out.println("If you want to multi-thread for better performance, write 'MT' ");
        System.out.println("Enter the string you want to enter");
        String s = in.next();
        if(!s.equals("MT")) {
            ISort a = SortAdapter.getSortObject(s);
            System.out.println("Enter the Input you want to enter");
            String s1 = in.next();
            System.out.println("Enter the Output you want to enter");
            String s2 = in.next();
            a.sort(s1, s2);
        }
        else{
            System.out.println("Enter the Input you want to enter");
            String s1 = in.next();
            System.out.println("Enter the Output you want to enter");
            String s2 = in.next();
            Thread t1= new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a = SortAdapter.getSortObject("Mergesort");
                    a.sort(s1, s2);
                }
            });
            Thread t2= new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a = SortAdapter.getSortObject("Bubblesort");
                    a.sort(s1, s2);
                }
            });
            Thread t3= new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a = SortAdapter.getSortObject("Heapsort");
                    a.sort(s1, s2);
                }
            });
            Thread t4= new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a = SortAdapter.getSortObject("Insertionsort");
                    a.sort(s1, s2);
                }
            });
            Thread t5= new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a = SortAdapter.getSortObject("Selectionsort");
                    a.sort(s1, s2);
                }
            });
            Thread t6= new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a = SortAdapter.getSortObject("Quicksort");
                    a.sort(s1, s2);
                }
            });
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
        }
    }
}
