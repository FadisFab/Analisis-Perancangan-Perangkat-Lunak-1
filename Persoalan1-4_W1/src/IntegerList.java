/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fadill
 */
// **************************************************************** 
// IntegerList.java 
// 
// Define an IntegerList class with methods to create, fill, 
// sort, and search in a list of integers. 
// 
// **************************************************************** 
import java.util.Scanner;
public class IntegerList
{
    int[] list; //values in the list
    //------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size. All elements default to value 0.
    //------------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
    }
    //------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    //------------------------------------------------------------
    public void randomize()
    {
        int max = list.length;
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * max) + 1;
    }
    //------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    //------------------------------------------------------------
    public void fillSorted()
    {
        for (int i=0; i<list.length; i++)
            list[i] = i + 2;
    }
    //------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    //------------------------------------------------------------
    public String toString()
    {
        String s = "";
        for (int i=0; i<list.length; i++)
            s += i + ":\t" + list[i] + "\n";
        return s;
    }    
    
 //----------------------------------------------------------------- 
 // sortDecreasing -- uses insertion sort 
 //----------------------------------------------------------------- 
    public void sortDecreasing()
    {
        for ( int index = 1; index < list.length; index++ )
        {
            int key = list[index];
            int position = index;
            while ( position > 0 && key > list[position - 1] )
            {
                list[position] = list[position - 1];
                position--;
            }
            list[position] = key;
        }
    }

    
 //------------------------------------------------------------ 
 // sortIncreasing -- uses selection sort 
 //------------------------------------------------------------ 
    public void sortIncreasing()
    {
        for (int i=0; i<list.length-1; i++)
        {
            int minIndex = minIndex(list, i);
            swap(list, i, minIndex);
        }
    }
    
    //Additional method to fill the sortIncreasing
    private int minIndex(int[] list, int i)
    {
        int minIndex = i;
        for ( int Index = i + 1; Index < list.length; Index++ )
        {
            if ( list[Index] < list[minIndex] )
            {
                minIndex = Index;
            }
        }
        return minIndex;
    }
    private void swap( int[] list, int i, int minIndex )
    {
        int iTemp = list[i];
        list[i] = list[minIndex];
        list[minIndex] = iTemp;
    }
    
    
    //------------------------------------------------------------ 
 // linearSearch -- takes a target value and returns the index 
 // of the first occurrence of target in the list. Returns -1 
 // if target does not appear in the list 
 //------------------------------------------------------------ 
    public int linearSearch(int target)
    {
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
            if (list[i] == target)
                location = i;
        return location;
    } 
    
    public int binarySearch(int target)
    {
        int left, middle, right;
        left = 0;
        right= (list.length - 1);
        middle = (left + right) / 2;
        while (list[middle] != target && left <= right)
        {
            if (target < list[middle])
                left = middle + 1;
            else
                right = middle - 1;
            
            middle = (left + right) / 2;

        }
        if (list[middle] == target)
            return middle;
        else
            return -1;
  }
}