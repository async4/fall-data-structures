


public class Util {
   
   private static final char[] chars = {'.', '+', '-', '*', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', ' '};


   public static boolean match(char other) {
      for (char ch: chars) {
         if (ch == other) {
            return true;
         }
      }
      
      return false;
   }
   
   public static int priority(String other) {
      switch (other) {
         case "^":
            return 3;
         case "*": case "/":
            return 2;
         case "+": case "-":
            return 1;
      }

      return -1;
   }

   public static int countMatches(String other, char payload) {
      int count = 0;

      for (char item: other.toCharArray()) {
         if (payload == item) {
            count++;
         }
      }

      return count;
   }

}
