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
