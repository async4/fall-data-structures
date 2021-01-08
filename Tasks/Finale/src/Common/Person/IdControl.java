package Common.Person;

public class IdControl {

   public static boolean check(String id) {
      if (id.length() != 11 ||
          !id.chars().allMatch(Character::isDigit) ||
          id.charAt(0) == 0 ||
          Integer.parseInt(String.valueOf(id.charAt(10))) % 2 != 0)
         return false;

      char[] charlist = id.toCharArray();

      int oddSum = 0;
      int evenSum = 0;

      for (int i = 0; i <= 8; i+=2)
         oddSum += Integer.parseInt(String.valueOf(charlist[i]));
      for (int i = 1; i < 9; i+=2)
         evenSum += Integer.parseInt(String.valueOf(charlist[i]));

      return true;  // rastgele 11 haneli cift sayi girmek icin burayi acip alttaki ifadeyi comment e alin.
      //return Math.abs((oddSum * 7) - evenSum) % 10 == Integer.parseInt(String.valueOf(charlist[9]));
   }
}
