package Common;

public class FinalPerson implements Comparable<FinalPerson> {
   public int key;
   Person data;

   public FinalPerson(int key, Person data) {
      this.key = key;
      this.data = data;
   }
   @Override
   public int compareTo(FinalPerson other) {
      return Integer.compare(this.key, other.key);
   }
}
