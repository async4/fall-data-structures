public class Queue {

   private int length;
   private int size;
   private int[] array;
   
   int head;

   public Queue(int length) {
      this.length = length;
      this.size = head = 0;
      this.array = new int[this.length];
   }

   public void enque(int data) {
      
      if (this.full()) {
         System.out.println("Queue is full");
      } else {
         if (this.head == this.length)
            this.head = 0;
         this.array[this.size] = data;
         this.size++;
      }
   }

   public void deque() {
      if (this.empty()) {
         System.out.println("Queue is empty");
      } else {
         this.array[head] = 0;
         this.head++;
         this.size--;
      }
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
