package Manager;

import Common.Blood.BloodType;
import Common.Graph.Graph;
import Common.Hash.Hash;
import Common.Heap.Heap;
import Common.Person.FinalPerson;
import Common.Person.Person;
import Common.Blood.BloodCheck;
import Common.Person.Generator;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class Controller {
   Graph<BloodType> bloodRelationGraph;
   Graph<FinalPerson> personBloodRelationGraph;
   Graph<FinalPerson> allPersonGraph;
   Heap donatorHeap;
   Heap receiverHeap;

   private void setUp() {
      bloodRelationGraph =  new Graph<>(8);

      // A Rh+
      bloodRelationGraph.add(BloodType.ARHP, BloodType.ARHP);
      bloodRelationGraph.add(BloodType.ARHP, BloodType.ABRHP);

      // A Rh-
      bloodRelationGraph.add(BloodType.ARHN, BloodType.ARHP);
      bloodRelationGraph.add(BloodType.ARHN, BloodType.ARHN);
      bloodRelationGraph.add(BloodType.ARHN, BloodType.ABRHP);
      bloodRelationGraph.add(BloodType.ARHN, BloodType.ABRHN);

      // B Rh+
      bloodRelationGraph.add(BloodType.BRHP, BloodType.BRHP);
      bloodRelationGraph.add(BloodType.BRHP, BloodType.ABRHP);

      // B Rh-
      bloodRelationGraph.add(BloodType.BRHN, BloodType.BRHP);
      bloodRelationGraph.add(BloodType.BRHN, BloodType.BRHN);
      bloodRelationGraph.add(BloodType.BRHN, BloodType.ABRHP);
      bloodRelationGraph.add(BloodType.BRHN, BloodType.ABRHN);

      // AB Rh+
      bloodRelationGraph.add(BloodType.ABRHP, BloodType.ABRHP);

      // AB Rh-
      bloodRelationGraph.add(BloodType.ABRHN, BloodType.ABRHN);
      bloodRelationGraph.add(BloodType.ABRHN, BloodType.ABRHP);

      // 0 Rh+
      bloodRelationGraph.add(BloodType.ZRHP, BloodType.ARHP);
      bloodRelationGraph.add(BloodType.ZRHP, BloodType.BRHP);
      bloodRelationGraph.add(BloodType.ZRHP, BloodType.ABRHP);
      bloodRelationGraph.add(BloodType.ZRHP, BloodType.ZRHP);

      // 0 Rh-
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.ZRHN);
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.ZRHP);
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.ARHP);
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.ARHN);
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.BRHP);
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.BRHN);
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.ABRHP);
      bloodRelationGraph.add(BloodType.ZRHN, BloodType.ABRHN);

      final int SIZE = 30;
      personBloodRelationGraph = new Graph<>(SIZE);
      allPersonGraph = new Graph<>(SIZE);
      donatorHeap = new Heap(SIZE);
      receiverHeap = new Heap(SIZE);
   }

   public void run() {
      setUp();
      // demo() // Hazir person object, hash uretir ve heaplere aktarir.

      Person person;

      while (true) {
         System.out.print("|1| Add Person\n|2| Match Persons\n|3| List Matched Persons\n|4| List All Persons\n>>> ");
         switch (new Scanner(System.in).nextInt()) {
            case 1:
               try {
                  person = Generator.generatePerson();
                  if (Objects.isNull(person))
                     System.out.println("\n\tPerson not created\n");
                  else {
                     System.out.println("\n\tCreated: " + person + "\n");
                     if (person.isDonator())
                        donatorHeap.add(new FinalPerson(Hash.key(person), person));
                     else if (person.isReceiver())
                        receiverHeap.add(new FinalPerson(Hash.key(person), person));
                  }
               } catch (IOException e) {
                  e.printStackTrace();
               }
               break;
            case 2:
               FinalPerson p1 = donatorHeap.getHead();
               FinalPerson p2 = receiverHeap.getHead();

               if (p1 == null && p2 == null) {
                  System.out.println("\n\tNo donors and receivers\n");
                  break;
               }

               if (p1 == null) {
                  System.out.println("\n\tNo donors\n");
                  break;
               }

               if (p2 == null) {
                  System.out.println("\n\tNo receivers\n");
                  break;
               }

               System.out.println("\n\tDonator: " + p1);
               System.out.println("\tReceiver: " + p2);

               if (BloodCheck.check(bloodRelationGraph, p1.data.getBloodType(), p2.data.getBloodType())) {
                  p1 = donatorHeap.extract();
                  p2 = receiverHeap.extract();
                  personBloodRelationGraph.add(p1, p2);
                  allPersonGraph.add(p1, p2);
                  System.out.printf("\n\tThe match is successfull %s -> %s\n\n", p1, p2);
               } else {
                  System.out.printf("\n\tIncompatibility detected. %s can not donate\n\n", p1);
                  p1 = donatorHeap.extract();
                  p2 = receiverHeap.extract();
                  allPersonGraph.add(p1, null);
                  allPersonGraph.add(p2, null);
               }
               break;
            case 3:
               System.out.println(personBloodRelationGraph);
               break;
            case 4:
               System.out.println(allPersonGraph);
               break;
            case 5: // donators heap
               donatorHeap.print();
               break;
            case 6: // receivers heap
               receiverHeap.print();
               break;
            case 7: // blood relation heap
               System.out.println(bloodRelationGraph);
               break;
         }
      }
   }

   // HAZIR OBJELER
   private void demo() {
      Person person1 = new Person("49830109160", "a", "-", BloodType.ARHN, true, false, false, false);
      Person person2 = new Person("22131209126", "0", "-", BloodType.ZRHN, true, false, false, false);
      Person person3 = new Person("30832287032", "0", "+", BloodType.ZRHP, true, false, false, false);
      Person person4 = new Person("21732592288", "ab", "-", BloodType.ABRHN, true, false, false, false);
      Person person5 = new Person("62237143590", "a", "+", BloodType.ARHP, true, false, false, false);
      Person person6 = new Person("81036245192", "ab", "-", BloodType.ABRHN, false, true, true, true);
      Person person7 = new Person("91936616610", "b", "+", BloodType.BRHP, false, true, false, false);
      Person person8 = new Person("19138021852", "a", "-", BloodType.ARHN, false, true, true, true);
      Person person9 = new Person("17430127108", "0", "-", BloodType.ZRHN, false, true, false, false);
      Person person0 = new Person("69430020844", "0", "+", BloodType.ZRHP, false, true, false, true);

      FinalPerson fp1 = new FinalPerson(Hash.key(person1), person1);
      FinalPerson fp2 = new FinalPerson(Hash.key(person2), person2);
      FinalPerson fp3 = new FinalPerson(Hash.key(person3), person3);
      FinalPerson fp4 = new FinalPerson(Hash.key(person4), person4);
      FinalPerson fp5 = new FinalPerson(Hash.key(person5), person5);
      FinalPerson fp6 = new FinalPerson(Hash.key(person6), person6);
      FinalPerson fp7 = new FinalPerson(Hash.key(person7), person7);
      FinalPerson fp8 = new FinalPerson(Hash.key(person8), person8);
      FinalPerson fp9 = new FinalPerson(Hash.key(person9), person9);
      FinalPerson fp0 = new FinalPerson(Hash.key(person0), person0);

      donatorHeap.add(fp1);
      donatorHeap.add(fp2);
      donatorHeap.add(fp3);
      donatorHeap.add(fp4);
      donatorHeap.add(fp5);

      receiverHeap.add(fp6);
      receiverHeap.add(fp7);
      receiverHeap.add(fp8);
      receiverHeap.add(fp9);
      receiverHeap.add(fp0);
   }
}
