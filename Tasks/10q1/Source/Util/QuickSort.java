package Util;

import java.util.ArrayList;


public class QuickSort {
   
   public static void sort (ArrayList<String> array, int left, int right) {
      int pivot;
      if (left < right) {
         pivot = QuickSort.partition(array, left, right);
         QuickSort.sort(array, left, pivot-1);
         QuickSort.sort(array, pivot+1, right);
      }
   }
   
   private static int partition (ArrayList<String> array, int left, int right) {
      String p  = array.get(right);
      int i = left-1;
      String temp;

      for (int j = left; j <= right-1; j++) {
         if (p.compareTo(array.get(j)) > 0) {
            i++;
            temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
         }
      }
      temp = array.get(i+1);
      array.set(i+1, array.get(right));
      array.set(right, temp);

      return i+1;
   }
}
