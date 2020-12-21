import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;


import java.text.CharacterIterator;
import java.text.StringCharacterIterator;


public class Parse {
   String expression;

   Stack<Character> stack;

   public Parse (String expression) {
      stack = new Stack<Character>();
      this.expression = expression.replaceAll(" ", "");
   }

   public ArrayList<String> parse() {
      ArrayList<String> array = new ArrayList<String>();
      String pack = new String();
      
      CharacterIterator iter = new StringCharacterIterator(this.expression);

      while (iter.current() != CharacterIterator.DONE) {
         char item = iter.current();

         if (!Util.match(item)) {
            System.out.printf("invalid expression: ( %c ) <-", item);
            System.exit(0);
         }

         if (Character.isDigit(item) || item == '.') {
            if (Util.countMatches(pack, '.') > 1) {
               System.out.printf("invalid expression: ( %c ) <-", item);
               System.exit(0);
            }
            pack += item;
            iter.next();
            continue;
         } else {
            array.add(pack);
            pack = "";
         }

         if (item == '(' && stack.empty()) {
            stack.push(item);
         } else if (item == '(') {
            stack.push(item);
            pack += item;
         } else if (item == ')' && stack.size() == 1) {
            stack.pop();
         } else if (item == ')' && !stack.empty()) {
            stack.pop();
            pack += item;
            array.add(pack);
            pack = "";
         } else {
            pack += item;
            array.add(pack);
            pack = "";
         }

         iter.next();
      }
      
      ArrayList<String> result = new ArrayList<String>();
      for (String item : array)
         if (item != "")
            result.add(item);
      return result;
   }

}
