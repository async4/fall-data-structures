/* 
   Worst Case Time Complexity [ Big-O ]: O(n2)
   Best Case Time Complexity [Big-omega]: O(n)
   Average Time Complexity [Big-theta]: O(n2)
   Space Complexity: O(1)
*/

public class Insertion {
   
   public static int[] sort(int[] array, int size) {
      for (int i = 0; i < size-1; i++) {
         for (int k = i+1; k > 0; k--) {
            if (array[k] < array[k-1]) {
               int temp = array[k];
               array[k] = array[k-1];
               array[k-1] = temp;
            }
         }
      }

      return array;
   }

}
