import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class App {
   public static void main(String[] args) {
      //String input = new Scanner(System.in).nextLine();
      Tree avl = new Tree();

      avl.add(5);
      avl.add(6);
      avl.add(2);
      avl.add(8);
      avl.add(0);
      avl.add(1);
      avl.add(9);
      avl.add(3);
      avl.traverse();

   }
}
