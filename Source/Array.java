public class Array {
   private int length;
   private int[] array;
   
   private int size;

   public Array(int length) {
      this.length = length;
      this.size = 0;
      this.array = new int[this.length];
   }
   
   public void append(int data) {
      if (this.full()) {
         System.out.println("Array is full");
      } else {
         this.array[this.size++] = data;
      }
   }

   public void pop() {
      if (this.empty()) {
         System.out.println("Array is empty");
      } else {
         this.array[this.size-1] = 0;
         this.size--;
      }
   }

   public boolean find(int data) {
      if (this.empty()) {
         System.out.println("Array is empty");
         return false;
      } 

      int index = 0;
      boolean result = false;
      
      while (index < this.size) {
         if (this.array[index] == data) {
            result = true;
            break;
         }

         else {
            index++;
            result = false;
         }
      }
      return result;
   }

   public boolean empty() {
      return this.size == 0;
   }

   public boolean full() {
      return this.size == this.length;
   }

   public int length() {
      return this.length;
   }

   public int size() {
      return this.size;
   }

   @Override
   public String toString() {
      String pack = "";

      for (int i: this.array)
         pack += i + " ";

      return pack;
   }
}
