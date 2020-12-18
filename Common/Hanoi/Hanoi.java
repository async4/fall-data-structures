public class Hanoi {

   public static void solve(int n, char src, char aux, char dest) {
      if (n == 0)
         return;

      Hanoi.solve(n-1, src, dest, aux);
      System.out.printf("%c to %c\n", src, dest);
      Hanoi.solve(n-1, aux, src, dest);
   }

}
