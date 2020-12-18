public class CarQueue {
   private int head;
   private int tail;
   private int size;

   private Car[] cars;

   public CarQueue(int length) {
      this.head = this.tail = this.size = 0;
      this.cars = new Car[length];
   }

   public boolean Insert(Car payload) {
      if (!this.isFull()) {
         if (this.tail == this.cars.length)
            this.tail = 0;
         this.cars[tail++] = payload;
         this.size++;
         return true;
      }
      System.out.println("Array is Full");
      return false;
   }

   public Car Remove() {
      if (!this.isEmpty()) {
         Car temp = this.cars[this.head++];

         if (this.head == this.cars.length)
            this.head = 0;
         this.size--;
         
         return temp;
      } 

      System.out.println("Array is Empty");
      return null;
   }

   public boolean isFull() { return this.size == this.cars.length; }

   public boolean isEmpty() { return this.size == 0; }

   public void Print() {
      System.out.println("_______________CARS________________");
      for (int i = this.head; i < this.head + this.size; i++)
         System.out.println(this.cars[i%this.cars.length].toString());
      System.out.println("___________________________________\n");

   }
}
