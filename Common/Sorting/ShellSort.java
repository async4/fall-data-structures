public class ShellSort {

   public static void sort (int[] array) {
      int n = array.length;

      for (int k = n/2; k > 0; k /= 2) {
         for (int i = k; i < n; i++) {
            int tmp = array[i];
            int j;

            for (j = i; j >= k && array[j-k] > tmp; j-=k)
               array[j] = array[j-k];
            array[j] = tmp;
         }
      }
   } 
}
