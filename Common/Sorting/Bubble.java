/* 
   Worst Case Time Complexity [ Big-O ]: O(n2)
   Best Case Time Complexity [Big-omega]: O(n)
   Average Time Complexity [Big-theta]: O(n2)
   Space Complexity: O(1)
*/

public class Bubble {

   public static int[] sort(int[] array, int size) {
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size-1; j++) {
            if (array[j] > array[j+1]) {
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1] = temp;
            }
         }
      }

      return array;
   }

}
