import java.util.Scanner;

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
         int choice = 0;

         while (true) {
            App.ui();
            try {
               choice = new Scanner(System.in).nextInt();
            } catch (Exception e) {
               System.out.println("invalid");
               new Scanner(System.in).nextLine();
               continue;
            }
            break;
         }

         switch (choice) {
            case 1:
               // GIRDI BIR DUZENLI IFADE OLDUGU ICIN "REGEX" KULLANILDI.
               // IKI PARANTEZ  ( (+, 10, 2) vb. ) ICINDEKI IFADELERIN HEPSINI OKUYABILIR.
               // HER PARANTEZLI IFADEDEN SONRA ',(VIRGUL)' KONULMASI GEREKIYOR. YOKSA CALISMAZ.
               // TEST GIRDISI: {(-, 11,5) , (/, 90, 5), (+, 3, 8), (*,6,11), (+, 60, 8), (+, 10, 4)}
               System.out.print("NODE [(operator, first, second), ...]: ");
               for (Node node: Parse.get(new Scanner(System.in).nextLine()))
                  avl.add(node);
               break;

            case 2:
               // DUZENLEME ISLEMI ICIN ONCE DUZENLENECEK NODE DEGERI BULUNUP TREE DEN SILINIR
               // TREE DEN SILINDIKTEN SONRA TREE KENDINI TEKRAR DUZENLER
               // DAHA SONRA SILINEN DEGERIN OZELLIKLERI ILE YENI BIR NODE OLUSTURULUP
               // TEKRARDAN TREE YE EKLENIR.
               avl.traverse();
               int value;

               while (true) {
                  System.out.print("Enter value: ");
                  value = new Scanner(System.in).nextInt();
                  break;
               }

               Node f = avl.find(value); // Istenilen eleman bulunur
               Node temp = new Node(f.operator, f.first, f.second); // bulunan node degerleri yeni node a aktarilir.
               if (f != null)  {
                  avl.delete(f.data); // Duzenlenmesi istenen node once silinir.
                  temp.update(); // node guncellenir.
                  avl.add(temp); // tekrardan tree ye eklenir.
                  System.out.println("changed: " + temp);
                  System.out.print("close (enter)...");
                  new Scanner(System.in).nextLine();
               } else
                  System.out.printf("not found: %d\n", value);

               break;

            case 3:
               // POSTORDER TRAVERSAL ILE TREE BASTIRILIR.
               avl.traverse();
               System.out.print("close (enter)...");
               new Scanner(System.in).nextLine();
               break;

            default:
               System.out.println("invalid");
               new Scanner(System.in).nextLine();
               break;
         }
      }
   }

   public static void main(String[] args) {
      App.run();
   }
}
