import java.util.ArrayList;

public class Solve {
   /*
   public static String run(String expression) {
      ArrayList<String> array;
      Node node = new Node(expression);

      if (!Character.isDigit(node.value)) {
         array = new Parse(node.value).parse();

         int min = 0;

         for (String item: array) {
            if (Character.isDigit())
               continue;

            if (Util.match(item)) {
               if (Util.priority(item) < Util.priority(array.get(min)))
                  min = array.indexOf(item);
            } else {
               System.out.printf("invalid expression: '%s' <-", item);
               System.exit(0);
            }
         }

         node.value = array.get(min);
         String left = new String();
         String right = new String();

         for (int i = 0; i < min; i++)
            left += array.get(i);

         for (int i = min+1; i <= array.size(); i++)
            right += array.get(i);

         
         node = Solve.run(left);
         node = Solve.run(right);

         return node.traverse();
      }

   }
   */
}
