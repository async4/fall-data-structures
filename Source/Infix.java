import java.util.Stack;

public class Infix {
   
   private static int priority(char payload) {
      switch (payload) {
         case '+':
         case '-':
            return 1;
         case '*':
         case '/':
            return 2;
         case '^':
            return 3;
      }

      return -1;
   }

   public static String toPostfix(String infix) {
      String result = new String();
      Stack<Character> stack = new Stack<>();

      for (char ch : infix.toCharArray()) {
         if (Character.isDigit(ch) || Character.isLetter(ch))
            result += ch;
         else if (ch == '(') 
            stack.push(ch);
         else if (ch == ')') {
            while (!stack.isEmpty() && stack.peek() != '(')
               result += stack.pop();
            stack.pop();
         } 
         else {
            while (!stack.isEmpty() &&
                  Infix.priority(ch) <= Infix.priority(stack.peek()))
               result += stack.pop();

            stack.push(ch);
            
         }
      }

      while (!stack.isEmpty()) {
         if (stack.peek() == '(')
            return "invalid";
         result += stack.pop();
      }

      return result;

   }

}
