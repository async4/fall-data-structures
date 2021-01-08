package Common.Person;

public class FinalPerson implements Comparable<FinalPerson> {
   public float key;
   public Person data;

   public FinalPerson(float key, Person data) {
      this.key = key;
      this.data = data;
   }
   @Override
   public int compareTo(FinalPerson other) {
      return Float.compare(key, other.key);
   }

   @Override
   public String toString() {
      return String.format("%s ( %s )", data.getId(), data.getBloodType());
   }
}
