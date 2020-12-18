/* 
   Worst Case Time Complexity [ Big-O ]: O(n2)
   Best Case Time Complexity [Big-omega]: O(n2)
   Average Time Complexity [Big-theta]: O(n2)
   Space Complexity: O(1)
*/

public class Selection {
   
   public static int[] sort(int[] array, int size) {
      int index = 0;
      
      while (index < size) {
         int min = index;

         for (int i = index+1; i < size; i++) {
            if (array[min] > array[i])
               min = i;
         }

         int temp = array[index];
         array[index] = array[min];
         array[min] = temp;
         index++;
      }
   
      return array;    
   }

}
