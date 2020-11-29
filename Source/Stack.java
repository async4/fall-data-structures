public class Stack {
   private int length;
   private int size;
   private int[] array;


   public Stack(int length) {
      this.length = length;
      this.size = 0;
      this.array = new int[this.length];
   }

   public void push(int data) {
      if (this.full()) {
         System.out.println("Stack is full");
      } else {
         this.array[this.size++] = data;
      }
   }

   public int pop() {
      if (this.empty()) {
         return 0;
      } else {
         int temp = this.array[size-1];
         this.array[this.size-1] = 0;
         this.size--;
         return temp;
      }
   }

   public int peek() {
      if (this.empty()) {
         System.out.println("Stack is empty");
      } else {
         return this.array[this.size];
      }
      return 0;
   }

   public boolean empty() {
      return this.size == 0;
   }

   public boolean full() {
      return this.size == this.length;
   }

   @Override
   public String toString() {
      String pack = "";

      for (int i: this.array)
         if (i != 0)
            pack += i + " ";

      return pack;
   }

}
