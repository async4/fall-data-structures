package Common.Person;

import Common.Blood.BloodType;

public class Person {
   private String id;
   private String bloodGroup;
   private String rhType;
   private BloodType bloodType;
   private boolean isDonator;
   private boolean isReceiver;

   // kisi 2 hastaliktan birine sahip ise hasta
   // sayilacagindan tek bir degisken yazildi.
   private boolean isDisease;
   private boolean isUrgency;

   public Person(String id, String bloodGroup, String rhType, BloodType bloodType,
                 boolean isDonator, boolean isReceiver,
                 boolean isDisease, boolean isUrgency) {
      this.id = id;
      this.bloodGroup = bloodGroup;
      this.rhType = rhType;
      this.bloodType = bloodType;
      this.isDonator = isDonator;
      this.isReceiver = isReceiver;
      this.isDisease = isDisease;
      this.isUrgency = isUrgency;
   }

   public String getId() {
      return id;
   }

   public BloodType getBloodType() {
      return bloodType;
   }

   public boolean isDonator() {
      return isDonator;
   }

   public boolean isReceiver() {
      return isReceiver;
   }

   public boolean isDisease() {
      return isDisease;
   }

   public boolean isUrgency() {
      return isUrgency;
   }

   @Override
   public String toString() {
      return String.format("[ %s, %s, %b, %b, %b ]",
              this.id, this.bloodType,
              this.isDonator, this.isReceiver,
              this.isDisease);
   }
}