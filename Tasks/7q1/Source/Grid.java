import java.util.Stack;
import java.util.ArrayList;


public class Grid {

   private int length;

   private Slot head;
   private Slot tail;

   private int size;

   private Stack<Slot> stack;


   public Grid(int length) {
      this.length = length;
      this.head = this.tail = null;
      this.size = 0;
      this.stack = new Stack<>();
   }

   public Grid(int length, Slot head, Slot tail) {
      this.length = length;
      this.head = head;
      this.tail = tail;
   }


   /* size % length => sutun numarasini verir.
    * size / length => satir numarasini verir.
    *
    *
    *
    */
   public void Add(Computer computer) {
      Slot slot = new Slot(computer);

      int row = this.size / this.length;
      int column = this.size % this.length;


      if (row == 0 && column == 0) {
         this.head = this.tail = slot;
      }

      else {
         Slot PH, H, PT, T;
         PH = H = this.head;
         PT = T = this.tail;

         while (PT != null)
         {
            if (slot.compareTo(PT) != 1) {
               if (stack.empty()) {
                  this.tail = slot;
                  slot.setLeft(T);
                  T.setRight(slot);
               } else {
                  PT.setRight(T);
                  T.setLeft(PT);
                  break;
               }
            }

            else {
               if (PT != null)
                  stack.push(PT);

               if (T != null && T != slot)
                  T = slot;

               if (PT == PH)
                  this.head = PH = H = slot;
            }
            PT = PT.getLeft();
         }

         while (!stack.empty()) {
            PT = stack.pop();
            T.setRight(PT);
            PT.setLeft(T);

            T = PT;
         }
      }

      this.size++;
   }



   public int getLength() {
      return this.length;
   }

   public Slot getHead() {
      return this.head;
   }

   public Slot getTail() {
      return this.tail;
   }

   public void setHead(Slot head) {
      this.head = head;
   }

   public void setTail(Slot tail) {
      this.tail = tail;
   }

   @Override
   public String toString() {
      Slot walk = this.head;
      String pack = "";

      while (walk != null) {
         pack += String.format("%s%s\n", walk.getData(), walk);
         walk = walk.getRight();
      }

      return pack;
   }

}
