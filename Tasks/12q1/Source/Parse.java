import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parse {
   
   public static ArrayList<Node> get(String other) {
      ArrayList<Node> result = new ArrayList<Node>();
      for (List<String> item: Parse.parse(other)) {
         result.add(new Node(
            (item.get(0)).charAt(0),
            Integer.parseInt(item.get(1)),
            Integer.parseInt(item.get(2))
         ));
      }

      return result;
   }

   private static ArrayList<List<String>> parse(String other) {
      other = other.replaceAll("\\s+", ""); // tum bosluklar silinir.
      //String pattern = "(?<=\\().*?(?=\\))"; // bu regex stringi parantez icindeki ifadelerin ne olduguna bakmiyor.
      String pattern = "(?<=\\()+[\\*\\-\\+\\/]+\\,+[\\d]*\\,+[\\d]*";
      Matcher m = Pattern.compile(pattern).matcher(other);
      ArrayList<List<String>> mat = new ArrayList<List<String>>();

      while (m.find()) // eslesen tum stringler arraylist e eklenir.
         mat.add(Arrays.asList(m.group(0).split(",")));

      return mat;
   }
}
