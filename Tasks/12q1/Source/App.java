import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class App {

   private static void ui() {
      System.out.println("\033[H\033[2J");
      System.out.flush();
      System.out.print("[1] add node\n[2] change node\n[3] print\n\n>>> ");
   }

   private static void run() {
      Tree avl = new Tree();

      while (true) {
         App.ui();

         switch (new Scanner(System.in).nextInt()) {
            case 1:
               System.out.print("NODE [(operator, first, second), ...]: ");
               for (Node node: Parse.get(new Scanner(System.in).nextLine())) 
                  avl.add(node);
               break;
            case 2:
               avl.traverse();
               String id;
               while (true) {
                  System.out.print("Enter the first 4 characters of the id value: ");
                  id = new Scanner(System.in).nextLine();
                  if (id.length() != 4) {
                     System.out.println("the first 4 character.");
                     continue;
                  }
                  break;
               }
               Node needtoupdate = avl.find(id);

               if (needtoupdate != null) {
                  avl.delete(needtoupdate);
               }
               break;
            case 3:
               avl.traverse();
               new Scanner(System.in).nextLine();
               break;
         }
      }

   }

   public static void main(String[] args) {
      App.run();
   }
}
