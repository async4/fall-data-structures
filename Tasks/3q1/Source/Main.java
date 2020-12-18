import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
      System.out.println("enter array size: ");
      MArray marray = new MArray(new Scanner(System.in).nextInt());
      
      boolean loop = true;

      do {
         System.out.println("1) Add\n2) Search\n3) Update\n4) Remove\n5) Print\n0) Exit");
         int ch = new Scanner(System.in).nextInt();

         switch (ch)
         {
            case 1:
               System.out.print("element to add: ");
               marray.Add(new Scanner(System.in).nextLine());
               break;
            case 2:
               System.out.print("search to element: ");
               int index = marray.Search(new Scanner(System.in).nextLine());
               System.out.println(index);
               break;
            case 3:
               System.out.print("who -> toWho");
               marray.Update(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine());
               break;
            case 4:
               System.out.println("remove to element: ");
               marray.Remove(new Scanner(System.in).nextLine());
               break;
            case 5:
               marray.Print();
               break;
            case 0:
               loop = false;
               break;
         }
      } while (loop);
      
   }
}
