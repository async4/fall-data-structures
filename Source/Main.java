public class Main {
	public static void main(String[] args) {
      int[] array = {6, 2, 1, 7, 8, 9, 4, 5, 3, 10};
      int size = 10;

      array = Merge.sort(array, size);

      for (int i : array)
         System.out.print(i + " ");
      System.out.println();
	}
}
