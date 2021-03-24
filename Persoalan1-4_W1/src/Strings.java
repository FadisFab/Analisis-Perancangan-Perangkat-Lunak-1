
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fadill
 */
public class Strings {
     // -------------------------------------------- 
 // Reads in an array of integers, sorts them, 
 // then prints them in sorted order. 
 // -------------------------------------------- 
    public static void main (String[] args) 
    { 
        int size; 
        
        Scanner scan = new Scanner(System.in); 
        System.out.print ("\nHow many strings do you want to sort? ");
        size = scan.nextInt(); 
        String[] strList = new String[size];

        
        System.out.println ("\nEnter the strings..."); 
        for (int i = 0; i < size; i++) 
            strList[i] = scan.next(); 
        
           Sorting.insertionSort(strList);
        System.out.println ("\nYour strings in sorted order..."); 
        
        for (int i = 0; i < size; i++) 
        System.out.print(strList[i] + " "); 
        System.out.println(); 
    } 

}
