package Manager;

import Common.*;


public class Controller {

   public static void run() {
      Person p1 = new Person("49833318848", "a", "-",  BloodType.ARHN, true, false, false, false);
      Person p2 = new Person("37839210240", "b", "+",  BloodType.BRHP, false, true, false, true);
      Person p3 = new Person("59834181442", "a", "-",  BloodType.ARHN, false, true, false, true);
      Person p4 = new Person("79834356340", "ab", "+",  BloodType.ABRHP, false, true, false, true);
      Person p5 = new Person("29834118744", "z", "-",  BloodType.ZRHN, true, false, false, false);
      Person p6 = new Person("32831918842", "z", "+",  BloodType.ZRHP, false, true, false, true);
      Person p7 = new Person("19834118740", "ab", "-",  BloodType.ABRHN, true, false, false, false);
      Person p8 = new Person("19834118740", "a", "+",  BloodType.ARHP, true, false, false, false);
      FinalPerson fp1 = new FinalPerson(6, p1);
      FinalPerson fp2 = new FinalPerson(14, p2);
      FinalPerson fp3 = new FinalPerson(45, p3);
      FinalPerson fp4 = new FinalPerson(78, p4);
      FinalPerson fp5 = new FinalPerson(2, p5);
      FinalPerson fp6 = new FinalPerson(47, p6);
      FinalPerson fp7 = new FinalPerson(53, p7);
      FinalPerson fp8 = new FinalPerson(128, p8);
      Heap heap = new Heap(9);
      heap.add(fp1);
      heap.add(fp2);
      heap.add(fp3);
      heap.add(fp4);
      heap.add(fp5);
      heap.add(fp6);
      heap.add(fp7);
      heap.add(fp8);
      heap.print();

      /*
      *  benim 2 adet graphim olacaktir.
      * bu graphin birincisi eger ki 2 ye basildiginda eslesen 2 kisi uyusuyorsa
      * birinci grapha eklenecek. eger ki eslesmiyorsa ikinci grapha eklenecek.
      *
      * */
      /*
      while (true) {
         try {
            person = Generator.generatePerson();
            if (Objects.isNull(person)) System.out.println("\n\tPerson not created\n");
            else {
               System.out.println("\n\tCreated: " + person + "\n");
               receiverTable.put(person);
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

       */


   }
}
