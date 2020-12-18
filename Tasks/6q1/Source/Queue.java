import java.util.Arrays;


public class Queue {

   private Customer[] _data;
   private final int _length = 100;
   
   private int _size;
   private int _rear, _front;


   public Queue() {
      this._data = new Customer[this._length];
      this._front = this._rear = this._size = 0;
   }

   public boolean enqueue(Customer customer) {
      if (!this.full()) {
         this._data[this._rear++] = customer;
         this._size++;
         return true;
      }
      return false;
   }

   public boolean dequeue() {
      if (!this.empty()) {
         for (int k = 1; k <= this._rear; k++)
            this._data[k-1] = this._data[k];
         this._rear--;
         this._size--;
         return true;
      }
      return false;
   }

   public boolean empty() {
      return this._size <= 0;
   }

   public boolean full() {
      return this._size >= this._length;
   }

   public Customer front() {
      return this._data[this._front];
   }

   public Customer rear() {
      return this._data[this._rear];
   }

   public Integer getSize() {
      return this._size;
   }

   public Customer[] getData() {
      return this._data;
   }

}
