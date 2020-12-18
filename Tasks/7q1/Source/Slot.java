public class Slot implements Comparable<Slot> {
   
   private Slot left;
   private Slot right;
   private Slot up;
   private Slot down;
   
   private Computer data;


   public Slot(Computer data) {
      this.data = data;
      this.left = this.right = this.up = this.down = null;
   }

   public Computer getData() {
      return this.data;
   }
   
   public Slot getLeft() {
      return this.left;
   }

   public Slot getRight() {
      return this.right;
   }

   public Slot getUp() {
      return this.up;
   }

   public Slot getDown() {
      return this.down;
   }

   public void setLeft(Slot left) {
      this.left = left;
   }

   public void setRight(Slot right) {
      this.right = right;
   }

   public void setUp(Slot up) {
      this.up = up;
   }

   public void setDown(Slot down) {
      this.down = down;
   }

   @Override
   public int compareTo(Slot slot) {
      return this.data.compareTo(slot.getData());
   }

   @Override
   public String toString() {
      String U, D, L, R;
      U = (this.up != null) ? this.up.getData().getName() : "empty";
      D = (this.down != null) ? this.down.getData().getName() : "empty";
      L = (this.left != null) ? this.left.getData().getName() : "empty";
      R = (this.right != null) ? this.right.getData().getName() : "empty";

      return String.format("<-- (U:%s, D:%s, L:%s, R:%s)\n", U, D, L, R);
   }
   
}
