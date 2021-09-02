package com.mcz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("How many random numbers would you like to sort? (2..100) >");

        Scanner scan = new Scanner(System.in);
        int sizeOfArray = 0;

        while(true) {
            if(!scan.hasNextInt()) {
                System.out.print("This is not an integer number. Please enter an integer within <2..100> range >");
            } else {
                sizeOfArray = scan.nextInt();
                if ((sizeOfArray >= 2) && (sizeOfArray <= 100)) {
                    break;
                }
                System.out.print("Please enter en integer within <2..100> range >");
            }
            scan.nextLine();
        }

        try {
            QuickSort quickSort = new QuickSort(sizeOfArray);
            quickSort.execute(0, sizeOfArray-1);
        } catch (Exception e) {
            System.out.println("An exception has occured!");
            System.out.println(e.toString());
            System.exit(-1);
        }
    }

}
