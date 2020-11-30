/* 
   Enqueue: O(1)
   Dequeue: O(1)
   Size: O(1)
*/

import java.util.Arrays;

public class Queue {

   private int length;
   private int size;
   private int[] array;
   
   private int head;
   private int tail;

   public Queue(int length) {
      this.length = length;
      this.size = 0;
      this.head = 0;
      this.tail = -1;
      this.array = new int[this.length];
   }

   public void enque(int data) {
      if (this.full()) {
         System.out.println("Queue is full");
      } else {
         this.tail = (this.tail+1) % this.length;
         this.array[this.tail] = data;
         this.size++;
      }
   }

   public void deque() {
      if (this.empty()) {
         System.out.println("Queue is empty");
      } else {
         this.head = (this.head+1) % this.length;
         this.size--;
      }
   }

   public int getHead() {
      return this.array[this.head];
   }

   public int getSize() {
      return this.size;
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

      pack += String.format("Size: %d\nHead: %d(%d) Tail: %d(%d)\nQueue: ", this.size, this.array[this.head], this.head, this.array[this.tail], this.tail);
      
      pack += Arrays.toString(this.array);
      return pack;
   }

}
