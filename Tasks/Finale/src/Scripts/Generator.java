package Scripts;

import Common.BloodType;
import Common.Person;

import java.io.IOException;
import java.util.Scanner;

public class Generator {
   private static String tempPersonId;
   private static BloodType tempBloodType;
   private static boolean tempIsDonator;
   private static boolean tempIsReceiver;
   private static boolean tempIsDisease;
   private static boolean tempIsUrgency;

   private static String tempBloodGroup;
   private static String tempRhType;

   private static void showCreatedPerson() {
      System.out.println("##################### PREVIEW ####################");
      System.out.printf("#\t\tPerson ID          :  %s\n", tempPersonId);
      System.out.printf("#\t\tPerson Blood Type  :  %s\n", tempBloodType);
      System.out.printf("#\t\tPerson is Donator  :  %b\n", tempIsDonator);
      System.out.printf("#\t\tPerson is Receiver :  %b\n", tempIsReceiver);
      System.out.printf("#\t\tPerson is Disease  :  %b\n", tempIsDisease);
      System.out.printf("#\t\tUrgency            :  %b\n", tempIsUrgency);
      System.out.println("###################################################");
   }

   public static Person generatePerson() throws IOException {
      Scanner scanner = new Scanner(System.in);

      while (true) {
         System.out.print("Person id: ");
         tempPersonId = scanner.nextLine();

         if (!IdControl.check(tempPersonId)) {
            System.out.printf("\n\tInvalid id: %s\n\n", tempPersonId);
            continue;
         }

         break;
      }

      while (true) {
         String group;
         String rhtype;
         String finalGroup;

         try {
            System.out.print("Person Blood Group: ");
            group = scanner.nextLine().toUpperCase();
            switch (group) {
               case "A", "B", "AB", "0" -> {
                  if (group.equals("0"))
                     group = "Z";
                  tempBloodGroup = group;
               }
               default -> {
                  System.out.printf("\n\tInvalid blood group: %s\n\n", group);
                  continue;
               }
            }
         } catch (IllegalArgumentException e) {
            System.out.println("\n\tError\n");
            continue;
         }

         try {
            System.out.print("Person Rh Type (+/-): ");
            rhtype = scanner.nextLine().toUpperCase();
            switch (rhtype) {
               case "+", "-" -> {
                  tempRhType = rhtype;
                  if (rhtype.equals("+"))
                     rhtype = "P";
                  else
                     rhtype = "N";
                  finalGroup = group + "RH" + rhtype;
               }

               default -> {
                  System.out.printf("\n\tInvalid Rh Type: %s\n\n", rhtype);
                  continue;
               }
            }
         } catch (IllegalArgumentException e) {
            System.out.println("\n\tError\n");
            continue;
         }

         tempBloodType = BloodType.valueOf(finalGroup);
         switch (tempBloodType) {
            case ARHP, ARHN,
                    BRHP, BRHN,
                    ABRHP, ABRHN,
                    ZRHN, ZRHP -> {
            }
            default -> {
               System.out.println("\n\tFatal Error\n");
               System.exit(0);
            }
         }

         break;
      }

      while (true) {
         System.out.print("Person is Donator? (y/n) ");
         switch (new Scanner(System.in).nextLine()) {
            case "y", "Y" -> tempIsDonator = true;
            case "n", "N" -> tempIsDonator = false;
            default -> {
               System.out.println("\n\tError\n");
               continue;
            }
         }
         break;
       }

      while (true) {
         System.out.print("Person is Receiver? (y/n) ");
         switch (new Scanner(System.in).nextLine()) {
            case "y", "Y" -> tempIsReceiver = true;
            case "n", "N" -> tempIsReceiver = false;
            default -> {
               System.out.println("\n\tError\n");
               continue;
            }
         }
         break;
      }

      while (true) {
         System.out.print("Person is Disease? (y/n) ");
         switch (new Scanner(System.in).nextLine()) {
            case "y", "Y" -> {
               tempIsDisease = true;
               if (tempIsDonator) {
                  System.out.println("\n\tWarning: The person is disease. Can not be donor.\n");
                  tempIsDonator = false;
               }
            }
            case "n", "N" -> tempIsDisease = false;
            default -> {
               System.out.println("\n\tError\n");
               continue;
            }
         }
         break;
      }

      while (tempIsReceiver) {
          System.out.print("Is Urgency? (y/n) ");
          switch (new Scanner(System.in).nextLine()) {
             case "y", "Y" -> tempIsUrgency = true;
             case "n", "N" -> tempIsUrgency = false;
             default -> {
                System.out.println("\n\tError\n");
                continue;
             }
          }
          break;
      }

      Person tempPerson = new Person(tempPersonId, tempBloodGroup, tempRhType,
                 tempBloodType, tempIsDonator, tempIsReceiver, tempIsDisease, tempIsUrgency);

      showCreatedPerson();
      System.out.print("Saved this person? (y/n): ");

      return switch (new Scanner(System.in).nextLine()) {
            case "y", "Y" -> tempPerson;
            case "n", "N" -> null;
            default -> throw new IllegalStateException("Unexpected value");
         };
      }
  }

