public class QuickSort {
   
   public void sort (int[] array, int left, int right) {
      int pivot;
      if (left < right) {
         pivot = this.partition(array, left, right);
         this.sort(array, left, pivot-1);
         this.sort(array, pivot+1, right);
      }
   }
   
   private int partition (int[] array, int left, int right) {
      int p = array[right];
      int i = left-1;
      int temp;

      for (int j = left; j <= right-1; j++) {
         if (array[j] <= p) {
            i++;

            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
         }
      }
      temp = array[i+1];
      array[i+1] = array[right];
      array[right] = temp;
      return i+1;
   }

}
