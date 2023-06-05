package org.algo.sort;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter sorting you want to perform and for multithreading use 'M':   ");
        String s=sc.next();

        if(s.equals("M")){
            System.out.println("Enter input : ");
            String i1=sc.next();
            System.out.println("Enter output : ");
            String i2=sc.next();

            Thread t1=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a=SortAdapter.getSortObject("BubbleSort");
                    a.sort(i1,i2);
                }
            });

            t1.start();

            Thread t2=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a=SortAdapter.getSortObject("BucketSort");
                    a.sort(i1,i2);
                }
            });

            t2.start();

            Thread t3=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a=SortAdapter.getSortObject("HeapSort");
                    a.sort(i1,i2);
                }
            });

            t3.start();

            Thread t4=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a=SortAdapter.getSortObject("InsertionSort");
                    a.sort(i1,i2);
                }
            });

            t4.start();

            Thread t5=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a=SortAdapter.getSortObject("MergeSort");
                    a.sort(i1,i2);
                }
            });

            t5.start();

            Thread t6=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a=SortAdapter.getSortObject("QuickSort");
                    a.sort(i1,i2);
                }
            });

            t6.start();

            Thread t7=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a=SortAdapter.getSortObject("SelectionSort");
                    a.sort(i1,i2);
                }
            });

            t7.start();

            Thread t8=new Thread(new Runnable() {
                @Override
                public void run() {
                    ISort a1=SortAdapter.getSortObject("ShellSort");
                    a1.sort(i1,i2);
                }
            });
            t8.start();

        }

        else{
            ISort a=SortAdapter.getSortObject(s);
            System.out.println("Enter input: ");
            String i1=sc.next();
            System.out.println("Enter output:");
            String i2= sc.next();
            a.sort(i1,i2);
        }
    }
}
