import java.util.Scanner;

public class Node {
   public int data;
   public char operator;
   public int first, second;
   public Node left, right;
   public int height;


   public Node(char operator, int first, int second) {
      this.operator = operator;
      this.first = first;
      this.second = second;
      this.data = getData();
      this.height = 1;
   }

   int getData() {
      switch (this.operator) {
         case '+':
            return this.first + this.second;
         case '-':
            return this.first - this.second;
         case '*':
            return this.first * this.second;
         case '/':
            return this.first / this.second;
      }

      return Integer.MIN_VALUE;
   }

   public void update() {
      System.out.print("\n\tenter new operator (default: enter): ");
      String new_operator = new Scanner(System.in).nextLine();
      if (!new_operator.isEmpty()) {
         this.operator = new_operator.charAt(0);
      }

      System.out.print("\n\tenter new first value (default: enter): ");
      String new_first = new Scanner(System.in).nextLine();
      if (!new_first.isEmpty()) {
         this.first = Integer.parseInt(new_first);
      }

      System.out.print("\n\tenter new second value (default: enter): ");
      String new_second = new Scanner(System.in).nextLine();
      if (!new_second.isEmpty()) {
         this.second = Integer.parseInt(new_second);
      }

      this.left = this.right = null;
      this.data = getData();
      this.height = 1;
   }

   public void transfer(Node payload) {
      this.operator = payload.operator;
      this.first = payload.first;
      this.second = payload.second;
   }

   @Override
   public String toString() {
      return String.format("%d%c%d=%d", this.first, this.operator, this.second, this.data);
   }
}
