public class Merge {
   /* 
    
       6, 2, 1, 7, 8, 9, 4, 5, 0, 10
       
       6 2 1 7 8
       9 4 5 0 10

       6 2
       1 7 8

       6 
       2
      
       1 7
       1
       7

       8

    */
   private static int[] gen(int[] array, int start, int end) {
      int[] temp = new int[end-start];
      
      int index = 0;
      for (int i = start; i < end; i++) {
         temp[index] = array[i];
         index++;
      }

      return temp;
   }
   
   private static void print(int[] array) {
      for (int i : array)
         System.out.print(i + " ");
      System.out.println();
   }

   private static int size(int[] array) {
      int size = 0;

      for (int i : array) 
         size++;
      return size;
   }

   private static int[] merge(int[] array, int[] left, int[] right) {
      int i = 0, j = 0, k = 0;
      int left_size = Merge.size(left);
      int right_size = Merge.size(right);

      while (i < left_size && j < right_size) {
         if (left[i] <= right[j]) {
            array[k] = left[i];
            i++;
         }
         else {
            array[k] = right[j];
            j++;
         }
         k++;
      }
      
      while (i < left_size) {
         array[k] = left[i];
         i++;
         k++;
      }

      while (j < right_size) {
         array[k] = right[j];
         j++;
         k++;
      }
      
      return array;
   }

   public static int[] sort(int[] array, int size) {
      if (size > 1) {
         int mid = size/2;
         int[] left = Merge.gen(array, 0, mid);
         int[] right = Merge.gen(array, mid, size);

         Merge.sort(left, Merge.size(left));
         Merge.sort(right, Merge.size(right));

         array = Merge.merge(array, left, right);
      }

      return array;
   }

}
